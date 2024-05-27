import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("-");
        String a = sc.next();
        String b = sc.next(), c = sc.next();
        System.out.print(a + "-" + c + "-" + b);
    }
}