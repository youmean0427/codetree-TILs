import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1000001];
        Arrays.fill(a, Integer.MAX_VALUE);
        int[] b = new int[1000001];
        Arrays.fill(b, Integer.MIN_VALUE);
        int n = sc.nextInt();
        int m = sc.nextInt();

  
        int time  = 1;
        int aNow = 0;
        for (int i = 0; i < n; i++)
        {
            char c = sc.next().charAt(0);
            int t = sc.nextInt();

            if (c == 'R') {
                aNow += 1;            
            for (int j = 1; j <= t; j++)
            {
                a[time] = aNow;
                time++;
                if (j != t)
                    aNow++;
            }
            }
            else
            {
                aNow -= 1;
                for (int j = 1; j <= t; j++)
                {
                    a[time] = aNow;
                    time++;
                    if (j!=t)
                        aNow--;
                }
            }
        }

        time  = 1;
        int bNow = 0;
        for (int i = 0; i < m; i++)
        {
            char c = sc.next().charAt(0);
            int t = sc.nextInt();

            if (c == 'R') {
                bNow += 1;            
            for (int j = 1; j <= t; j++)
            {
                b[time] = bNow;
                time++;
                if (j != t)
                    bNow++;
            }
            }
            else
            {
                bNow -= 1;
                for (int j = 1; j <= t; j++)
                {
                    b[time] = bNow;
                    time++;
                    if (j!=t)
                        bNow--;
                }
            }
        }
        

        int ans = -1;
        for (int i = 1; i <= 1000000; i++)
        {
            if (a[i] == b[i])
            {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}