import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1000001];
        int[] b = new int[1000001];
        int n = sc.nextInt();
        int m = sc.nextInt();

        int time  = 1;
        for (int i = 0; i < n; i++)
        {
            char c = sc.next().charAt(0);
            int t = sc.nextInt();
            
            for (int j = 1; j <= t; j++)
            {
                if (c == 'R')
                    a[time] = a[time - 1] + 1;
                else
                    a[time] = a[time - 1] - 1;
                time++;
            }
        }

        int timeLim = time;

        time  = 1;
        for (int i = 0; i < m; i++)
        {
            char c = sc.next().charAt(0);
            int t = sc.nextInt();

            for (int j = 1; j <= t; j++)
            {
                if (c == 'R')
                    b[time] = b[time - 1] + 1;
                else
                    b[time] = b[time - 1] - 1;
                time++;
            }

        }
        
        int ans = -1;
        for (int i = 1; i < timeLim; i++)
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