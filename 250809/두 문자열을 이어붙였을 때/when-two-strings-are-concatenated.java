import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        String ans = "true";

        String c = a + b;
        String d = b + a;

        for (int i = 0; i < c.length(); i++)
        {
            if (c.charAt(i) != d.charAt(i))
            {
                ans = "false";
                break;
            }
        }
        System.out.print(ans);
    }
}