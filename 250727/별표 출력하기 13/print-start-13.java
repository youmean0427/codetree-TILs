import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 2 * n; i++)
        {
            if (i % 2 != 0)
            {
                for (int j = 1; j <= n - (i - 1)/2; j++)
                {
                    System.out.print("* ");
                }
            }
            else
            {
                for (int j = 0; j <= (i - 1)/2; j++)
                {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }


    }
}