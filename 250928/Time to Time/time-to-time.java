import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
    
    
        int ans = 0;

        while(true)
        {
            if (a == c && b == d)
                break;

            b++;
            ans++;
            if (b == 60)
            {
                a++;
                b=0;
            }
        }

        System.out.print(ans);
    }
}