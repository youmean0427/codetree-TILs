import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func1(n);
        func2(n);
    }


    public static void func1(int n)
    {
        if (n <= 0)
            return;
        System.out.print(n + " ");
        func1(n-1);
    }
    public static void func2(int m)
    {
        if (m <= 0)
            return;
        func2(m-1);
        System.out.print(m + " ");
    }
}