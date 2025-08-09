import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        func(n, m);
    }

    public static void func(int n, int m)
    {
        int ans = 1;
        for (int i = n; i >= 1; i--)
        {
            if (n % i == 0)
            {
                if (m % i == 0)
                {
                    ans = i;
                    break;
                }
            }
        }

        System.out.print(ans);
    }
}