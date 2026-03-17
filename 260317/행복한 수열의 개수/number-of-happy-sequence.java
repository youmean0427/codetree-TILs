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
            while (b < n-1)
            {
                b++;

                if (arr[i][a] == arr[i][b])
                {
                    cnt++;

                }
                else 
                {
                    a = b;
                }
            }
            if (cnt >= m)
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
            while (b < n-1)
            {
                b++;

                if (arr[a][i] == arr[b][i])
                {
                    cnt++;

                }
                else 
                {
                    a = b;
                }
            }
            if (cnt >= m)
            {
                ans++;
            }
        }
        
        System.out.print(ans);

    }
}