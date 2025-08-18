import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(F(n, n)); 
    }

    public static int F(int n, int m)
    {
        if (m % 2 != 0 && n == 1)
            return 1;
        if (m % 2 == 0 && n == 2)
            return 2;
        if ((m % 2 != 0 && n % 2 == 0) || (m % 2 == 0 && n % 2 != 0))
            return F(n-1, m);
        else
            return F(n-1, m) + n;
    }
}