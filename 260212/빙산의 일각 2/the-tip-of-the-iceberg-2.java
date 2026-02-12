import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            max = Math.max(h[i], max);
        }
        
        int ans = 0;
        for (int height = 0; height <= max; height++)
        {
            int[] res = new int[n];
            for (int i = 0; i < n; i++)
            {
                res[i] = height - h[i];
            }

            int ice = 0;
            int now = 0;
            for (int i = 0; i < n; i++)
            {
                if (now == 0 && res[i] < 0)
                {
                    now = 1;
                    ice++;
                }
                else if (res[i] >= 0)
                {
                    now = 0;
                }
            }
            ans = Math.max(ans, ice);
  
        }
        System.out.print(ans);
    }
}