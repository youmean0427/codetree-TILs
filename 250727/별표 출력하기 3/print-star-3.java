import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i > 0; i--)
        {
            for (int l = 0; l < n - i; l++)
            {
                System.out.print("  ");
            }
            for (int j = 0; j < (2*i)-1; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}