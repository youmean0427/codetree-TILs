import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        int x = 0;
        int two = 1;
        int ans = 0;
        for (int i = binary.length()-1; i >= 0; i--)
        {
            x = (int)binary.charAt(i) - 48;
            ans += x * two;
            two *= 2;
        }

        System.out.print(ans);
    }
}