import java.util.*;


class Pos {
    int x;
    int y;

    Pos (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k, m, ans;
    public static int[][] arr;
    public static ArrayList<Pos> stones = new ArrayList<>();
    public static ArrayList<Pos> removeStones = new ArrayList<>();
    public static ArrayList<Pos> starts = new ArrayList<>();
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 1)
                {
                    stones.add(new Pos(i, j));
                }
            }
        }

        for (int i = 0; i < k; i++)
        {
            starts.add(new Pos(sc.nextInt()-1, sc.nextInt()-1));
        }

        dfs(0, 0);
        System.out.print(ans);

    }

    public static void bfs()
    {
        
        Deque<Pos> dq = new ArrayDeque<>();
        int cnt = 0;
        int[][] visited = new int[n][n];
        int[][] movement = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int j = 0; j < starts.size(); j++)
        {
            cnt++;
            visited[starts.get(j).x][starts.get(j).y] = 1;
            dq.add(new Pos(starts.get(j).x, starts.get(j).y));
        }
        
        while (!dq.isEmpty())
        {
            Pos dqp = dq.poll();
            
            
            for (int m = 0; m < 4; m++)
            {
                int mx = dqp.x + movement[m][0];
                int my = dqp.y + movement[m][1];

                if (mx >= 0 && mx < n && my >= 0 && my < n)
                {
                    if (arr[mx][my] == 0 && visited[mx][my] == 0)
                    {
                        cnt++;
                        visited[mx][my] = 1;
                        dq.add(new Pos(mx, my));
                    }
                }
            }
        }
   
        ans = Math.max(ans, cnt);
    }


    public static void dfs(int cnt, int startIdx)
    {
        if (cnt >= m)
        {
            for (int i = 0; i < removeStones.size(); i++)
            {
                arr[removeStones.get(i).x][removeStones.get(i).y] = 0;
            }
    
            bfs();
            
            for (int i = 0; i < removeStones.size(); i++)
            {
                arr[removeStones.get(i).x][removeStones.get(i).y] = 1;
            }
            return;
        }
        
        for (int i = startIdx; i < stones.size(); i++)
        {
            int nx = stones.get(i).x;
            int ny = stones.get(i).y;
            removeStones.add(new Pos(nx, ny));
            dfs(cnt+1, startIdx+1);
            removeStones.remove(removeStones.size()-1);
        }
    }
}