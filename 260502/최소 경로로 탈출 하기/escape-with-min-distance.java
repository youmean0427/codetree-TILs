import java.util.*;

class Pair {
    int x, y;

    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, m, ans;
    public static int[][] arr, visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        visited[0][0] = 1;
        q.add(new Pair(0, 0));
        bfs();

        if (visited[n-1][m-1] == 0)
            ans = -1;
        else
            ans = visited[n-1][m-1] - 1;
        
        System.out.print(ans);

    }

    public static boolean isRange(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    public static boolean canGo(int x, int y)
    {
        return arr[x][y] == 1 && visited[x][y] == 0;
    }

    public static void bfs()
    {
        int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty())
        {
            Pair curr = q.poll();

            for (int i = 0; i < 4; i++)
            {
                int nextX = curr.x + pos[i][0];
                int nextY = curr.y + pos[i][1];

                if (isRange(nextX, nextY) && canGo(nextX, nextY))
                {
                    visited[nextX][nextY] = visited[curr.x][curr.y] + 1;
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }

}