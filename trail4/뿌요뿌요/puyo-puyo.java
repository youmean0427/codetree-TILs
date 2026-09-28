import java.util.*;

public class Main {
    public static int n, cnt, total, ans;
    public static int[][] visited, arr;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        visited = new int[n][n];
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
                total = 0;
                if (visited[i][j] == 0)
                {   
                    visited[i][j] = 1;
                    dfs(i, j, arr[i][j], 1);
                    if (total >= 4)
                        cnt++;
                    ans = Math.max(ans, total);
                }
            }
        }
        System.out.println(cnt + " " + ans);
        
    }
    public static int isRange(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < n)
        {
            return 1;
        }
        return 0;
    }

    public static void dfs(int x, int y, int num, int sum)
    {
        total++;
        int[][] pos = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int idx = 0; idx < 4; idx++)
        {
            int nx = x + pos[idx][0];
            int ny = y + pos[idx][1];

            if (isRange(nx, ny) == 1)
            {
                if (visited[nx][ny] == 0 && arr[nx][ny] == num)
                {
                    visited[nx][ny] = 1;
                    dfs(nx, ny, num, sum+1);
                    
                }
            }
        }
    }
}