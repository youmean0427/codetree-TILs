import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = 1;
        int b = n;


        for (int i = 1; i <= 2*n; i++)
        {

            if (i % 2 != 0)
            {
                for (int j = 1; j <= a; j++)
                {
                    System.out.print("* ");
                }
                
                a += 1;
            }
            else
            {
                for (int j = 1; j <= b; j++)
                {
                    System.out.print("* ");
                }
                b -= 1;
            }



            System.out.println();


        }

    }
}


