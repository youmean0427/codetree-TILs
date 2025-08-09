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
        int ans = n * m;
        for (int i = Math.min(n, m); i <= n * m; i++)
        {
            if (i % n == 0 && i % m  == 0)
            {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}