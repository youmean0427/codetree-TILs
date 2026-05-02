import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int x, y;
    
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] visited, grid;
    public static int n, m;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        q.add(new Pair(0, 0));
        bfs();

        System.out.print(visited[n-1][m-1]);
    }

    public static boolean isRange(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void bfs()
    {
        int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty())
        {
            Pair now = q.poll();

            for (int i = 0; i < 4; i++)
            {
                int nextX = now.x + pos[i][0];
                int nextY = now.y + pos[i][1];

                if (isRange(nextX, nextY))
                {
                    if (grid[nextX][nextY] == 1 && visited[nextX][nextY] == 0)
                    {
                        visited[nextX][nextY] = 1;
                        q.add(new Pair(nextX, nextY));
                    }
                }
            }
        }
    }
}