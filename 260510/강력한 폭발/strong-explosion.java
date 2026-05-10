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
    public static int[] bombNum;
    public static int bombCnt, n, ans;
    public static List<Pair> bombPosition = new ArrayList<>();
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
                    bombCnt++;
                    // 폭탄이 있는 위치
                    bombPosition.add(new Pair(i, j));
                }
            }
        }
        // bombPosition와 idx를 맞춰서 폭단 번호 매칭
        bombNum = new int[bombCnt];
        dfs(0);
        System.out.print(ans);
    }


    public static void bomb()
    {
        int[][] bombed = new int[n][n];
        int[][][] bombShape = new int[][][]{
            {},
            {{-1, 0}, {-2, 0}, {0, 0}, {1, 0}, {2, 0}},
            {{-1, 0}, {0, -1}, {0, 0}, {1, 0}, {0, 1}},
            {{-1, -1}, {-1, 1}, {0, 0}, {1, 1}, {1, -1}}
        };

        for (int i = 0; i < bombPosition.size(); i++)
        {
            Pair p = bombPosition.get(i);
            for (int idx = 0; idx < 5; idx++)
            {
                int nx = p.x + bombShape[bombNum[i]][idx][0];
                int ny = p.y + bombShape[bombNum[i]][idx][1];

                if (range(nx, ny))
                {
                    bombed[nx][ny] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (bombed[i][j] == 1)
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
        if (idx >= bombCnt)
        {
            bomb();
            return;
        }

        for (int i = 1; i <= 3; i++)
        {
            if (bombNum[idx] == 0)
            {
                bombNum[idx] = i;
                dfs(idx+1);
                bombNum[idx] = 0;
            }
        }
    }
}