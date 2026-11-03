import java.util.*;

class Pos {
    int x;
    int y;

    Pos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static Deque<Pos> nextDq = new ArrayDeque<>();
    public static int[][] visited, grid;
    public static int n, m, iceCnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];

        Deque<Pos> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1)
                {
                    iceCnt++;
                }
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
                {
                    dq.add(new Pos(i, j));
                    visited[i][j] = 1;
                }
            }
        }      

        int sec = 1;
        int lastIce = 0;

        lastIce = dfs(dq);

        if (iceCnt != 0)
        {
            while(!nextDq.isEmpty())
            {
                while(!nextDq.isEmpty())
                {
                    Pos ndq = nextDq.poll();
                    dq.add(new Pos(ndq.x, ndq.y));
                }

                lastIce = dfs(dq);
                sec++;
                if (iceCnt == 0)
                {
                    break;
                }
              
            }
        }
        System.out.println(sec + " " + lastIce);
    }


    public static int dfs(Deque<Pos> dq)
    {
        int removeIce = 0;
        
        while(!dq.isEmpty())
        {
            Pos dqp = dq.poll();
            int dx = dqp.x;
            int dy = dqp.y;

            int[][] move = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
            
            
            for (int mIdx = 0; mIdx < 4; mIdx++)
            {
                int nx = dx + move[mIdx][0];
                int ny = dy + move[mIdx][1];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m)
                {
                    if (grid[nx][ny] == 1 && visited[nx][ny] == 0)
                    {
                        visited[nx][ny] = 1;
                        grid[nx][ny] = 0;
                        nextDq.add(new Pos(nx, ny));
                        removeIce++;
                        iceCnt--;
                    }
                    else if (grid[nx][ny] == 0 && visited[nx][ny] == 0)
                    {
                        visited[nx][ny] = 1;
                        dq.add(new Pos(nx, ny));
                    }
                }
            }
        }
        return removeIce;

    }
}