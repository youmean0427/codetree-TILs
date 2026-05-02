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
    public static int n, ex, ey, ans;
    public static int[][] arr, visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        arr = new int[n][n];
        visited = new int[n][n];
    
        int sx = sc.nextInt()-1;
        int sy = sc.nextInt()-1;
        q.add(new Pair(sx, sy));
        visited[sx][sy] = 1;
        ex = sc.nextInt()-1;
        ey = sc.nextInt()-1;

        bfs();

        if (ans == 0)
        {
            ans = -1;
        }
        else
        {
            ans -= 1;
        }
        System.out.print(ans);
    }

    public static boolean isRange(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y)
    {
        return isRange(x, y) && visited[x][y] == 0;
    }

    public static void bfs()
    {
        int[][] pos = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
        while (!q.isEmpty())
        {
            Pair curr = q.poll();

            if (curr.x ==ex && curr.y == ey)
            {
                ans = visited[curr.x][curr.y];
                return;
            }
            for (int idx = 0; idx < 8; idx++)
            {  
                int nX = curr.x + pos[idx][0];
                int nY = curr.y + pos[idx][1];

                if (canGo(nX, nY))
                {
                    visited[nX][nY] = visited[curr.x][curr.y] + 1;
                    q.add(new Pair(nX, nY));
                }
            }
        }
    }
}