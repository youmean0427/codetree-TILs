import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.next();
       double a = sc.nextDouble();
       double b = sc.nextDouble();

       System.out.printf("%s\n%.2f\n%.2f", s, a, b);
    }
}