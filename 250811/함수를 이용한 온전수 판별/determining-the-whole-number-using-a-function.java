import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    

        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        for (int i = n; i <= m; i++)
        {
            if (func1(i) && func2(i) && func3(i))
            {
                ans += 1;
            }
        }
        System.out.print(ans);
    }

    public static boolean func1(int n)
    {
        if (n % 2 == 0)
            return false;
        return true;
    }

    public static boolean func2(int n)
    {
        int x = 0;
        while (n >= 10)
        {
            x = n % 10;
            n /= 10;
        }
        
        if (x == 5)
            return false;
        return true;
    }

    public static boolean func3(int n)
    {
        if (n % 3 == 0 && n % 9 != 0)
            return false;
        return true;
    }
}