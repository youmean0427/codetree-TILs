import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int ans = 0;
        for (int i = x; i <= y; i++)
        {
            ans += check(i);
        }
        System.out.print(ans);
    }

    public static int check(int x)
    {
        int[] cnt = new int[10];
        while(x >= 10)
        {
            cnt[x % 10]++;
            x /= 10;
            
        }
        cnt[x]++;
        
        int zero = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10; i++)
        {
            if (cnt[i] == 0)
            {
                zero++;
            }
            else if (cnt[i] == 1)
            {
                a = 1;
            }
            else
            {
                b = 1;
            }
        }

        if (zero == 8 && a == 1 && b == 1 )
        {
            return 1;
        }
        return 0;
    }
}