import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    public static int[] select;
    public static int bomb, n, ans;
    public static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        int[][] grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1)
                {
                    bomb++;
                    // 폭탄이 있는 위치
                    list.add(new Pair(i, j));
                }
            }
        }
        // list와 idx를 맞춰서 폭단 번호 매칭
        select = new int[bomb+1];
        dfs(0);
        System.out.print(ans);
    }


    public static void bomb()
    {
        int[][] visited = new int[n][n];
        int[][] bombOne = new int[][]{{-1, 0}, {-2, 0}, {0, 0}, {1, 0}, {2, 0}};
        int[][] bombTwo = new int[][]{{-1, 0}, {0, -1}, {0, 0}, {1, 0}, {0, 1}};
        int[][] bombThree = new int[][]{{-1, -1}, {-1, 1}, {0, 0}, {1, 1}, {1, -1}};

        for (int i = 0; i < list.size(); i++)
        {
            Pair p = list.get(i);
            if (select[i] == 1)
            {
                for (int idx = 0; idx < 5; idx++)
                {
                    int nx = p.x + bombOne[idx][0];
                    int ny = p.y + bombOne[idx][1];

                    if (range(nx, ny))
                    {
                        visited[nx][ny] = 1;
                    }
                }
            }
            else if (select[i] == 2)
            {
                for (int idx = 0; idx < 5; idx++)
                {
                    int nx = p.x + bombTwo[idx][0];
                    int ny = p.y + bombTwo[idx][1];

                    if (range(nx, ny))
                    {
                        visited[nx][ny] = 1;
                    }
                }             
                
            }
            else
            {
                for (int idx = 0; idx < 5; idx++)
                {
                    int nx = p.x + bombThree[idx][0];
                    int ny = p.y + bombThree[idx][1];

                    if (range(nx, ny))
                    {
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (visited[i][j] == 1)
                {
                    cnt += 1;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    public static boolean range(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void dfs(int idx)
    {
        if (idx >= bomb)
        {
            bomb();
            return;
        }

        for (int i = 1; i <= 3; i++)
        {
            if (select[idx] == 0)
            {
                select[idx] = i;
                dfs(idx+1);
                select[idx] = 0;
            }
        }
    }
}