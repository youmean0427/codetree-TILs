import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        func1(1, n);
        System.out.println();
        func2(n);
    }

    public static void func1(int n, int m)
    {
        System.out.print(n + " ");
        if (n >= m)
            return;
        func1(n+1, m);
    }

    public static void func2(int n)
    {
        System.out.print(n + " ");
        if (n <= 1)
            return;
        func2(n-1);
    }
}