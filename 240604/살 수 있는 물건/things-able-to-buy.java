import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "no";
        if (n >= 3000) {
            ans = "book";
        } else if (n >= 1000 ) {
            ans = "mask";
        }

        System.out.print(ans);

    }
}