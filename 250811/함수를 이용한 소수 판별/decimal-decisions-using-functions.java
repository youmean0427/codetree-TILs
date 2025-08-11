import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = 0;

        for (int i = a; i <= b; i++)
        {
            ans += primeNumber(i);
        }
        System.out.print(ans);
    }

    public static int primeNumber(int n)
    {
        int ans = 0;
        for (int i  = 1; i <= n; i++)
        {
            if (n % i == 0)
            {
                ans += 1;
            }

            if (ans > 2)
            {
                return 0;
            }
        }
        return n;
    }
}