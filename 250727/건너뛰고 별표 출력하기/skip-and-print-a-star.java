import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
        {
            for (int l = 0; l <= i; l++)
            {
                System.out.print("*");
            }
            System.out.println();
            System.out.println();
        }

        for (int i = n-1; i > 0; i--)
        {
            for (int l = 0; l < i; l++)
            {
                System.out.print("*");
            }
            System.out.println();
            System.out.println();
        }
    }
}