import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = n; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("*");
            }
            for (int l = 0; l < 2*(n-i); l++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++)
            {
                System.out.print("*");
            }


            System.out.println();
        }
    }
}