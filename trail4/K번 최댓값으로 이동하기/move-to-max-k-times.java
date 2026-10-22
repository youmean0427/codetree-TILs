import java.util.*;

class Pos{
    int x;
    int y;
    
    Pos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}


public class Main {
    public static int[][] grid, visited;
    public static int n, k,maxVal,minX, minY;
    public static Deque<Pos> dq = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        
        maxVal = 0;
        minX = r-1;
        minY = c-1;

        for (int idx = 0; idx < k; idx++)
        {
            int oldX = minX;
            int oldY = minY;


            visited = new int[n][n];
            dq.offer(new Pos(minX, minY));
            bfs(minX, minY);

            if (minX == n)
            {
                minX = oldX;
                minY = oldY;
                break;
            }
        }

        System.out.print((minX+1) +" "+ (minY+1));

       
    }


    public static void bfs(int x, int y)
    {
            maxVal = 0;
            minX = n;
            minY = n;

        while (!dq.isEmpty())
        {
            Pos now = dq.poll();
            int nx = now.x;
            int ny = now.y;


            int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            
            
            for (int i = 0; i < 4; i++)
            {
                int nnx = nx + dir[i][0];
                int nny = ny + dir[i][1];
                
                if (nnx >= 0 && nnx < n && nny >= 0 && nny < n)
                {
                    if (grid[x][y] > grid[nnx][nny])
                    {
                        if (visited[nnx][nny] == 0)
                        { 
                            visited[nnx][nny] = 1;
                            if (grid[nnx][nny] > maxVal)
                            {
                                maxVal = grid[nnx][nny];
                                minX = nnx;
                                minY = nny;
                            }
                            else if(grid[nnx][nny] == maxVal)
                            {
                                if (nnx < minX || (nnx == minX && nny < minY))
                                {
                                    minX = nnx;
                                    minY = nny;
                                }
                            }

                        dq.offer(new Pos(nnx, nny));
                        }
                    }
                }
            }
        }

    }
}