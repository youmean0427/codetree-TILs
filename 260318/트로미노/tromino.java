import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans = Math.max(ans, line(grid, i, j, n, m));
                ans = Math.max(ans, three(grid, i, j, n, m));
            }
        }
        System.out.print(ans);
    }

    public static int check(int n, int m, int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < m)
            return 1;
        return 0;
    }

    public static int line(int[][] grid, int sx, int sy, int n, int m)
    {
        int maxCnt = 0;
        int cnt = 0;        
        for (int i = sy; i < sy+3; i++)
        {
            if ( i >= 0 && i < m)
                cnt += grid[sx][i];
            else
            {
                cnt = 0;
                break;
            }    
        }
        maxCnt = Math.max(maxCnt, cnt);
        cnt = 0;
        for (int i = sx; i < sx+3; i++)
        {
            if (i >= 0 && i < n)
                cnt += grid[i][sy];
            else
            {
                cnt = 0;
                break;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }

    public static int three(int[][] grid, int sx, int sy, int n, int m)
    {
        int cnt = 0;

        if (check(n, m, sx, sy+1) == 1 && check(n, m, sx-1, sy+1) == 1)
        {
            cnt = Math.max(cnt, grid[sx][sy] + grid[sx][sy+1] + grid[sx-1][sy+1]);
        }
        if (check(n, m, sx+1, sy ) == 1 && check(n, m, sx+1, sy+1) == 1)
        {
            cnt = Math.max(cnt, grid[sx][sy] + grid[sx+1][sy] + grid[sx+1][sy+1]);
        }
        if (check(n, m, sx, sy-1) == 1 && check(n, m, sx+1, sy-1) == 1)
        {
            cnt = Math.max(cnt, grid[sx][sy] + grid[sx][sy-1] + grid[sx+1][sy-1]);
        }
        if (check(n, m, sx-1, sy) == 1 && check(n, m, sx-1, sy-1) == 1)
        {
            cnt = Math.max(cnt, grid[sx][sy] + grid[sx-1][sy] + grid[sx-1][sy-1]);
        }
        return cnt;

    } 


}