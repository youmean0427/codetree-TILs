import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] list;
    public static int[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new int[n][m];
        visited = new int[n][m];
        visited[0][0] = 1;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                list[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.print(visited[n-1][m-1]);
    }

    public static int isRange(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < m)
        {
            return 1;
        }
        return 0;
    }

    public static void dfs(int x, int y)
    {
        int[][] pos = new int[][]{{1, 0}, {0, 1}};
        for (int i = 0; i <= 1; i++)
        {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (isRange(nx, ny) == 1)
            {
                if (list[nx][ny] == 1 && visited[nx][ny] == 0)
                {
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }        
    }

}