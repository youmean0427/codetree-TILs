import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        if (b >= a && c >= a ) {
            System.out.print(a);
        } else if (a >= b && c >= b) {
            System.out.print(b);
        } else if (a >= c && b >= c) {
            System.out.print(c);
        }
        
    }
}