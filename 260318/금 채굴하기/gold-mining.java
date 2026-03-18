import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nxn
        int m = sc.nextInt(); // cost
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                ans = Math.max(ans, gold(grid, i, j, n, m));
            }
        }
        System.out.print(ans);
    }

    public static int gold(int[][] grid, int x, int y, int n, int m)
    {
        int ans = 0;
        int maxCost = 0;
        int goldCnt = 0;
        int costSum = grid[x][y];
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        int[] edgeX = {0, 0, 0, 0};
        int[] edgeY = {0, 0, 0, 0};
        int[][] visited = new int[n][n];
        visited[x][y] = 1;

        // K=0
        if (grid[x][y] == 1)
        {
            ans = 1;
        }

        // K=1
        for (int i = 0; i < 4; i++)
        {
            if (x+dirX[i] < 0 || x+dirX[i] >= n || y+dirY[i] < 0 || y+dirY[i] >= n)
            {
                continue;
            }
            else {
                costSum += grid[x+dirX[i]][y+dirY[i]];
                edgeX[i] = x+dirX[i];
                edgeY[i] = y+dirY[i];
                visited[edgeX[i]][edgeY[i]] = 1;
            }
        }
        if ((costSum * m) - 5 > 0)
        {
            ans = costSum;
        }

        // K=2~
        for (int i = 2; i <= n; i++)
        {
            
            for (int j = 0; j < 4; j++)
            {
                int ex = edgeX[j];
                int ey = edgeY[j];
                for (int l = 0; l < 4; l++)
                {

                    if (ex+dirX[l] >= 0 && ex+dirX[l] < n && ey+dirY[l] >= 0 && ey+dirY[l] < n)
                    {
                        if (visited[ex+dirX[l]][ey+dirY[l]] == 0) 
                        {
                            visited[ex+dirX[l]][ey+dirY[l]] = 1;
                            costSum += grid[ex+dirX[l]][ey+dirY[l]];
                        }
                    }  

                    if (j == l)
                    {
                            edgeX[j] = ex+dirX[l];
                            edgeY[j] = ey+dirY[l];
                        }
                }            
            }
            if ((costSum * m) - (i * i + (i + 1) * (i + 1)) > 0)
            {
                if (maxCost <= (costSum * m) - (i * i + (i + 1) * (i + 1)))
                {
                    maxCost = (costSum * m) - (i * i + (i + 1) * (i + 1));
                    goldCnt = costSum;
                }
            }
        }
        ans = Math.max(ans, goldCnt);
        return ans;
    }
}