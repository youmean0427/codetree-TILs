import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] aTime = new int[1000001];
        Arrays.fill(aTime, -1000001);
        int[] bTime = new int[1000001];
        Arrays.fill(bTime, -1000001);
        int aNow = 0;
        int bNow = 0;
        int now = 1;
        aTime[0] = 0;
        bTime[0] = 0;

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            for (int j = aNow; j < aNow + t; j++)
            {
                if (d == 'R')
                {
                    aTime[now] = aTime[now-1] + 1;
                }
                else
                {
                    aTime[now] = aTime[now-1] - 1;
                }
                now++;
            }
        }
        int aa = now-1;
        int lastA = aTime[now-1];

        now = 1;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);
            for (int j = bNow; j < bNow + t; j++)
            {
                if (d == 'R')
                {
                    bTime[now] = bTime[now-1] + 1;
                }
                else
                {
                    bTime[now] = bTime[now-1] - 1;
                }
                now++;
            }
        }
        int lastB = bTime[now-1];
        int bb = now - 1;
        int ans = 0;

        if (aa > bb )
        {
            for (int i = 1; i < aa; i++)
            {
                if (i-1 != 0 && aTime[i] == bTime[i])
                {
                    if (i-1 != 0 && aTime[i-1] != bTime[i-1])
                        ans += 1;
                }
                if (i > bb && lastB == aTime[i])
                {
                    if (aTime[i-1] != lastB)
                    {
                        ans += 1;
                    }
                }
            }
        }
        else
        {
            for (int i = 1; i < bb; i++)
            {
                if (i-1 != 0 && aTime[i] == bTime[i])
                {
                    if (i-1 != 0 && aTime[i-1] != bTime[i-1])
                        ans += 1;
                }
                if (i > aa && lastA == bTime[i])
                {
                    if (bTime[i-1] != lastA)
                    {
                        ans += 1;
                    }
                }
            }
        }

        System.out.print(ans);
    }
}