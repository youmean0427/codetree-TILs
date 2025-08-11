import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int ans = 0;
        for (int i = a; i <= b; i++)
        {
            if (primeNumber(i) && func(i))
                ans += 1;
        }

        System.out.print(ans);
    }

    public static boolean primeNumber(int n)
    {
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
                return false;
            
        }
        return true;
    }

    public static boolean func(int n)
    {
        int ans = 0;
        while (n > 0)
        {
            ans += n % 10;
            n /= 10;
        }

        if (ans % 2 == 0)
            return true;
        return false;
    }
}