import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int cnt = 0; cnt <= n; cnt++)
                {
                    int gold = 0;
                    for (int x = 0; x < n; x++)
                    {
                        for (int y = 0; y < n; y++)
                        {
                            
                            if (x >= 0 && x < n && y >= 0 && y < n)
                            {
                                if (Math.abs(x - i) + Math.abs(y - j) <= cnt)
                                {
                                    gold += grid[x][y];
                                }
                            }
                        }
                    }
                    if (((cnt * cnt) + (cnt + 1) * (cnt + 1)) <= (gold * m))
                        ans = Math.max(gold, ans);
                
                }
            }
        }
        System.out.print(ans);
    }
}