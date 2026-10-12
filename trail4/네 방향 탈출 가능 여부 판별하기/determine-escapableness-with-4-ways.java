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
    public static Deque<Pos> dq = new ArrayDeque<>();
    public static int[][] grid, visited;
    public static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        dq.offer(new Pos(0, 0));
        bfs();
        System.out.print(visited[n-1][m-1]);
    }

    public static void bfs()
    {
        while (!dq.isEmpty())
        {
            Pos p = dq.poll();
            int x = p.x;
            int y = p.y;

            int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < 4; i++)
            {
                int nx = x + position[i][0];
                int ny = y + position[i][1];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m)
                {
                    if (visited[nx][ny] == 0 && grid[nx][ny] == 1)
                    {
                        visited[nx][ny] = 1;
                        dq.offer(new Pos(nx, ny));
                    }
                }
            }
        }
    }
}