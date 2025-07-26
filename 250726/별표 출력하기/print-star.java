import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for (int i = 1; i <= (2*n-1)/2; i++)
        {

            for (int j = 1; j <= i; j++) 
            {
                System.out.print("* ");
            } 
            System.out.println();
        }

        for (int a = 0; a < n; a++)
        {
            System.out.print("* ");
        }

        System.out.println();
        for (int i = 1; i <= (2*n-1)/2; i++)
        {
            for (int l = n; l > i; l--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}