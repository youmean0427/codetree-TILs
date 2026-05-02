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
    public static int n, k, ans;
    public static int[][] arr, visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++)
        {
            int startX = sc.nextInt() - 1;
            int startY = sc.nextInt() - 1;
            visited[startX][startY] = 1;
            q.add(new Pair(startX, startY));
           
        }
        bfs();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(visited[i][j] == 1)
                    ans++;

        System.out.print(ans);
    }

    public static boolean isRange(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y)
    {
        return arr[x][y] == 0 && visited[x][y] == 0;
    }

    public static void bfs()
    {
        int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!q.isEmpty())
        {
            
            Pair now = q.poll();

            for (int i = 0; i < 4; i++)
            {
                int nextX = now.x + pos[i][0];
                int nextY = now.y + pos[i][1];

                if (isRange(nextX, nextY) && canGo(nextX, nextY))
                {
                        visited[nextX][nextY] = 1;
                        q.add(new Pair(nextX, nextY));
                }
            }
        }
    }
}