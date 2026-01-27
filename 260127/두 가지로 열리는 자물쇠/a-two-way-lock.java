import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        
        int ans = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int k = 1; k <= n; k++)
                {
                    if (((a + n - i <= 2) || Math.abs(i - a) <= 2) && ((b + n - j <= 2) || Math.abs(j - b) <= 2) && ((c + n - k <= 2) || Math.abs(k - c) <= 2))
                    {
                            ans++;
                    }
                    else if (((a2 + n - i <= 2) || Math.abs(i - a2) <= 2) && ((b2 + n - j <= 2) || Math.abs(j - b2) <= 2) && ((c2 + n - k <= 2) || Math.abs(k - c2) <= 2))
                    {
                            ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}