import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i > 1; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }       

        for (int j = 1; j < n+1; j++)
        {
            for (int l = 0; l < j; l++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}