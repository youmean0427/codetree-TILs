import java.util.Scanner;
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
    public static Queue<Pos> q = new LinkedList<>();
    public static int n, m;
    public static int[][] grid, visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        visited[0][0] = 1;
        q.offer(new Pos(0, 0));
        bfs();
        
        if (visited[n-1][m-1] == 1)
            System.out.print(1);
        else
            System.out.print(0);
    }

    public static boolean isRange(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < m)
            return true;
        return false;
    }

    public static void bfs()
    {
        while (!q.isEmpty())
        {
            Pos qp = q.poll();
            int x = qp.x;
            int y = qp.y;

            int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int i = 0; i < 4; i++)
            {
                int nx = x + move[i][0];
                int ny = y + move[i][1];

                if (isRange(nx, ny) && grid[nx][ny] == 1 && visited[nx][ny] == 0)
                {
                    visited[nx][ny] = 1;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
    }
}