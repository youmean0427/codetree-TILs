import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int[] visited;
    public static int n, m;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new int[n+1];
        // for (int i = 0; i < n; i++) {
        //     visited[i] = 0;
        // }
        back(1, 1);

    }

    public static void back(int cnt, int start)
    {
        if (cnt > m)
        {
            for (int idx = 0; idx < list.size(); idx++)
            {
                System.out.print(list.get(idx) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++)
        {
            if (visited[i] == 0)
            { 
                list.add(i);
                visited[i] = 1;
            
                back(cnt+1, i);
                list.remove(list.size()-1);
                visited[i] = 0;
            }
        }

    }
}