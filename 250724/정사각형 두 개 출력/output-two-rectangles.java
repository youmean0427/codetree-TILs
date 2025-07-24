import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        for (int n = 0; n < 2; n++){

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    System.out.print("*");

                }
                System.out.println();


            }
            if (n == 0)
                System.out.print("\n");
        }
    }
}