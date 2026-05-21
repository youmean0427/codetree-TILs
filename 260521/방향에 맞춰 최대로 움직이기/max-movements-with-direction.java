import java.util.*;

public class Main {
    public static int n, sx, sy, ans;
    public static int[][] arr, pos;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];
        pos = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                pos[i][j] = sc.nextInt();
            }
        }

        sx = sc.nextInt();
        sy = sc.nextInt();
        
        dfs(sx-1, sy-1, 0);
        System.out.print(ans);
        
    }

    public static void dfs(int x, int y, int cnt)
    {
        int[] dx = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 0, 1, 1, 1, 0, -1, -1, -1};
        ans =  Math.max(ans, cnt);
        
        for (int i = 1; i < n; i++)
        {
            int nx = x + (dx[pos[x][y]] * i);
            int ny = y + (dy[pos[x][y]] * i);

            if (0 <= nx && nx < n && 0 <= ny && ny < n)
            {
                if (arr[nx][ny] > arr[x][y])
                {
                    dfs(nx, ny, cnt+1);
                }
            }

        }
    }
}