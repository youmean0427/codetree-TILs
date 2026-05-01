import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int[] visited;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n+1];
        back(1);

    }

    public static void back(int cnt)
    {
        if (cnt > n)
        {
            for (int j = 0; j < list.size(); j++)
            {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = n; i >= 1; i--)
        {
            if (visited[i] == 1)
                continue;
            list.add(i);
            visited[i] = 1;
            back(cnt+1);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
}