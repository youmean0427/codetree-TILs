import java.util.Scanner;

public class Main {
    public static int n, ex, ey, ans;
    public static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = 0;
        n = sc.nextInt();
        arr = new int[n][n];
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
                ex = i;
                ey = j;
                dfs(i, j, 0, 0);
            }
        }

        System.out.print(ans);
 
    }

    public static boolean canGo(int x, int y)
    {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static void move (int x, int y, int idx, int sum)
    {
        
        int[] dx = new int[]{0, -1, -1, 1, 1};
        int[] dy = new int[]{0, 1, -1, -1, 1};

        int nx = x + dx[idx];
        int ny = y + dy[idx];

        if (canGo(nx, ny))
        {
            sum += arr[x][y];
            dfs(nx, ny, idx, sum);
            sum -= arr[x][y];
        }


    }

    public static void dfs(int x, int y, int dir, int sum)
    {
        if (dir == 4)
        {
            if (x == ex && y == ey)
            {
                ans = Math.max(ans, sum);
                return;
            }
        }

        int nx;
        int ny;
        if (dir == 0) 
        {  
            move(x, y, 1, sum);
        }
        else if(dir == 1)
        {
            move(x, y, 1, sum);
            move(x, y, 2, sum);
        }
        else if (dir == 2)
        {
            move(x, y, 2, sum);
            move(x, y, 3, sum);
        }
        else if (dir == 3)
        {
            move(x, y, 3, sum);
            move(x, y, 4, sum);
        }
        else if (dir == 4)
        {
            move(x, y, 4, sum);
        }
    }
}