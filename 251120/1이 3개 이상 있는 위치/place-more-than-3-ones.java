import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cnt = 0;
                for (int idx = 0; idx <= 3; idx++)
                {
                    int dxx = i + dx[idx];
                    int dyy = j + dy[idx];
                    if (check(n, dxx, dyy) == 1) {
                        if (arr[dxx][dyy] == 1)
                            cnt += 1;
                    }
                }   
                if (cnt >= 3)
                    ans++;
            }
        }
        System.out.print(ans);
    }

    public static int check(int n, int x, int y)
    {
        if (x > -1 && x < n && y > -1 && y < n)
            return 1;
        return 0;
    }
    
    
}