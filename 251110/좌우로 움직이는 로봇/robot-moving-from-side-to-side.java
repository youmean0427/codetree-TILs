import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] aTime = new int[1000001];
        int[] bTime = new int[1000001];
        int aNow = 1;
        int bNow = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            for (int j = 0; j < t; j++)
            {
                if (d == 'R')
                    aTime[aNow] = aTime[aNow-1] + 1;
                else
                    aTime[aNow] = aTime[aNow-1] - 1;
                aNow++;
            }
        }


        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j = 0; j < t; j++)
            {
                if (d == 'R')
                    bTime[bNow] = bTime[bNow-1] + 1;
                else
                    bTime[bNow] = bTime[bNow-1] - 1;
                bNow++;
            }
        }

        if (aNow < bNow)
        {
            for (int i = aNow; i < bNow; i++)
            {
                aTime[i] = aTime[i-1];
            }
        }
        else if (aNow > bNow)
        {
            for (int i = bNow; i < aNow; i++)
            {
                bTime[i] = bTime[i-1];
            }
        }

        for (int i = 1; i < Math.max(aNow, bNow); i++)
        {
            if (aTime[i] == bTime[i] && aTime[i-1] != bTime[i-1])
            {
                ans++;
            }
        }

        System.out.print(ans);
    }
}