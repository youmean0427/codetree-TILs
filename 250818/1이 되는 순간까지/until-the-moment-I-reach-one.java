import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(F(n, 0));
    }

    public static int F(int n, int m)
    {
        if (n <= 1)
            return m;
        else if (n % 2 == 0)
            return F(n / 2, m + 1);
        else
            return F(n / 3, m + 1);
        
    }
}