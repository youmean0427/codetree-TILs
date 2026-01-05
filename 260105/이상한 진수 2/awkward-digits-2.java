import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        double x = Math.pow(2 , a.length() - 1);
        int flag = 0;
        int ans = 0;
        for (int i = 0; i < a.length(); i++)
        {

            if (flag == 0 && a.charAt(i) == '0')
            {
                ans += x * ((int)(a.charAt(i)) - 47);
                flag = 1;
            }
            else if (flag == 0 && i == a.length() - 1)
            {
                continue;
            }
            else
            {
                ans += x * ((int)(a.charAt(i)) - 48);
            }
            x /= 2;
            
        }
        System.out.print(ans);
    }
}