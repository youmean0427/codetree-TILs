import java.util.*;

public class Main {

    public static List<Integer> list = new ArrayList<>();
    public static int n, ans;
    public static int[][] cost;
    public static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = Integer.MAX_VALUE;
        visited = new int[n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        choose(0, 0);
        System.out.println(ans);
    }

    public static void choose(int cnt, int sum)
    {
        if (cnt == n)
        {
            if (cost[list.get(list.size()-1)][0]!= 0)
            {
                sum += cost[list.get(list.size()-1)][0];
                ans = Math.min(ans, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (visited[i] == 1)
                continue;
            
            if (list.size() >= 1 && cost[list.get(list.size() - 1)][i] == 0)
                continue;
            
            visited[i] = 1;
            list.add(i);
            if (list.size() == 1 && i != 0)
                continue;

            if (list.size() == 1)
            {
                choose(cnt + 1, sum);
            }
            else 
            {
                choose(cnt + 1, sum+cost[list.get(list.size() - 2)][i]);

            }
            list.remove(list.size() - 1);
            visited[i] = 0;

        }

    }
}