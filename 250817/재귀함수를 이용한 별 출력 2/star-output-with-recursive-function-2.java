import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        func1(n);

    }


    public static void func1(int n)
    {
        if (n == 0)
            return;
        for (int i = 0; i < n; i++)
        {
            System.out.print("* ");
        }
        System.out.println();
        func1(n-1);   
        for (int i = 0; i < n; i++)
        {
            System.out.print("* ");
        }
        System.out.println();
    }

}