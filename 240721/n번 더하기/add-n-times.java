import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int n = sc.nextInt();

        int i = n;
        while(i > 0) {
            a = a + n;
            System.out.println(a);
            i--;
        }

    }
}