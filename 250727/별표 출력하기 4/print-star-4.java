import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }       

        for (int j = i + 1; j < n; j++)
        {
            for (int l = 0; l < j; l++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}