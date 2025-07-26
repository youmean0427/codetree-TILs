import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - i-1; j++)
            {
                System.out.print(" ");
            }
            for (int l = 0; l <= i*2; l++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = n-1; i > 0; i--)
        {
            for (int j = 0; j < n-i; j++)
            {
                System.out.print(" ");
            }
            for (int l = 0; l < 2*i-1; l++)
            {
                System.out.print("*");
            }
            
            System.out.println();

        }
    }
}