import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 1;
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            if (num % 3 != 0) {
                ans = 0;
                break;
            }
        }
        System.out.print(ans);
    }
}