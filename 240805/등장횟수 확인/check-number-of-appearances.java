import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int a = sc.nextInt();

            if (a % 2 ==0) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}