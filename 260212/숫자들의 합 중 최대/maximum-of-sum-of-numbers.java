import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int ans = 0;
        for (int i = x; i <= y; i++)
        {
            int cnt = 0;
            int n = i;
            while (n >= 10)
            {
                cnt += n % 10;
                n /= 10;
            }
            cnt += n;

            ans = Math.max(ans, cnt);
        }

        System.out.print(ans)
    }
}