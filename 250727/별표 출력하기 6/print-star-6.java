import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n-1; i++)
        {
            for (int l = 0; l < i; l++)
            {
                System.out.print("  ");
            }
            for (int j = 0; j < 2*(n-i)-1; j++)
            {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int i = n; i > 0; i--)
        {
            for (int l = i; l > 1; l--  )
            {
                System.out.print("  ");
            }
            for (int j = 0; j < 2*(n-i+1)-1; j++)
            {
                System.out.print("* ");
            }
            System.out.println();

        }


    }
}