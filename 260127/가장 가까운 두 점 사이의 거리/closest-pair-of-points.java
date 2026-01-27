import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i != j)
                {
                    
                    int dis = (x[j] - x[i]) * (x[j] - x[i]) +  (y[j] - y[i]) * (y[j] - y[i]);
                    ans = Math.min(ans, dis);
                }
            }
        }
        System.out.println(ans);
    }
}