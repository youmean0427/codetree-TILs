import java.util.Scanner;

public class Main {
    public static int ans;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        int[] visited = new int[n+1];
        int x, y;

        for (int i = 0; i < m; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited[1] = 1;
        dfs(1, n, graph, visited);

        System.out.print(ans);
    }

    public static void dfs(int start, int n, int[][] graph, int[] visited)
    {
        for (int i = 0; i <= n; i++)
        {
            if (graph[start][i] == 1 && visited[i] == 0)
            {
                visited[i] = 1;
                ans++;
                dfs(i, n, graph, visited);
            }
        }
    }
}