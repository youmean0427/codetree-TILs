import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
        {
            for (int a = 1; a <= n-i; a++)
            {
                System.out.print(" ");
            }
            for (int l = 1; l <= i; l++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n-1; i++)
        {
            for (int a = 1; a <= i; a++)
            {
                System.out.print(" ");
            }
            for (int l = 1; l <= n-i; l++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}