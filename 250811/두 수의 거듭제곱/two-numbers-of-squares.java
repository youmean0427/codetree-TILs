import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tmp = a;
        while (b > 1)
        {
            a *= tmp;
            b -= 1;
        }

        System.out.print(a);
    }
}