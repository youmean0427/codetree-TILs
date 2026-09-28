import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[][] visited, map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = 1;
        dfs(0, 0);
        System.out.print(ans);
        
    }
    public static int canGo(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 1)
        {
            return 1;
        }
        return 0;
    }

    public static void dfs(int x, int y)
    {
        int[][] pos = new int[][]{{1, 0}, {0, 1}};

        if (x == n - 1 && y == m - 1)
        {
            ans = 1;
        }

        for (int i = 0; i < 2; i++)
        {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (canGo(nx, ny) == 1)
            {
                if (visited[nx][ny] == 0)
                {   
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }
    }
}