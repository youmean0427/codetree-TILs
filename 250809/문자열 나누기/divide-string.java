import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String ans = "";

        for (int i = 0; i < 9; i++)
        {
            ans += sc.next();
        }

        int cnt = 0;
        for (int i = 0; i < ans.length(); i++)
        {
            System.out.print(ans.charAt(i));
            cnt += 1;

            if (cnt == 5)
            {
                System.out.println();
                cnt = 0;
            }
        }

    }
}