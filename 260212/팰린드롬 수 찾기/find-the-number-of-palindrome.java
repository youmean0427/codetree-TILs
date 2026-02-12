import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int ans= 0;
        for (int i = x; i <= y; i++)
        {
            int n = i;
            int[] cnt = new int[7];
            int d = 0;
            while (n >= 10)
            {
                cnt[d] = n % 10;
                n /= 10;
                d++;
            }
            
            cnt[d] = n;
            int flag = 0;
       
            for (int j = 0; j <= d; j++)
            {
                if (cnt[j] == cnt[d-j])
                {
                    flag = 1;
                }
                else
                {
                    flag = 0;
                }
            }

            if (flag == 1)
            {
                ans++;
            } 
        }
        System.out.print(ans);
    }
}