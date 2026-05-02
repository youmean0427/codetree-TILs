import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int ans;
    public static ArrayList<Integer>[] graph = new ArrayList[1001];

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] visited = new int[n+1];
        int x, y;

        for (int i = 0; i <= n; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = 1;
        dfs(1, visited);

        System.out.print(ans);
    }

    public static void dfs(int vertex, int[] visited)
    {
        for (int i = 0; i < graph[vertex].size(); i++)
        {
            int currV = graph[vertex].get(i);
            if (visited[currV] == 0)
            {
                visited[currV] = 1;
                ans++;
                dfs(currV, visited);
            }
        }
    }
}