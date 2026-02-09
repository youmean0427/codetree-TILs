import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
           
        }
        int[] cnt = new int[101];
        
        // 교점으로 찾기

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                double D = (x2[i] - x1[i]) - (x2[j] - x1[j]);

                double t = (x1[j] - x1[i]) / D;

                if (0.0 <= t && t <= 1.0)
                {
                    double xx = x1[i] + (x2[i] - x1[i]) * t;
                    double yy = t;

                    cnt[i] = 1;
                    cnt[j] = 1;
                } 

            }
        }

        int ans = 0;
        for (int k = 0; k < n; k++)
        {
            if (cnt[k] == 0)
            {
                ans++;
            }
        }
        System.out.print(ans);
     
    }
}
