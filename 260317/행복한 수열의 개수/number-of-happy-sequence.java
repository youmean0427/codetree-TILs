import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;

        // 가로
        for (int i = 0; i < n; i++)
        {
            int a = 0;
            int b = 0;
            int cnt = 1;
            int maxCnt = 0;
            while (b < n)
            {
                b++;
                if (b == n)
                {
                    maxCnt = Math.max(maxCnt, cnt);
                    break;
                }
                
                if (arr[i][a] == arr[i][b])
                {
                    cnt++;

                }
                else 
                {
                    a = b;
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                }
            }
            if (maxCnt >= m)
            {
                ans++;
            }
        }

        // 세로
        for (int i = 0; i < n; i++)
        {
            int a = 0;
            int b = 0;
            int cnt = 1;
            int maxCnt = 0;
            while (b < n)
            {
                b++;
                if (b == n)
                {
                    maxCnt = Math.max(maxCnt, cnt);
                    break;
                }

                if (arr[a][i] == arr[b][i])
                {
                    cnt++;

                }
                else 
                {
                    a = b;
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 1;
                }
            }
            if (maxCnt >= m)
            {
                ans++;
            }
        }
        
        System.out.print(ans);

    }
}