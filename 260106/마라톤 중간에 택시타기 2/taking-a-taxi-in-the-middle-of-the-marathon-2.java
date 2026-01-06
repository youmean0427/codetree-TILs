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
        

        int not = 1;
        int ans = Integer.MAX_VALUE;
        while (not < n-1)
        {    
            int cnt = 0;
            for (int j = 1; j < n; j++)
            {
                if (j - 1 == not)
                {
                    cnt += Math.abs(x[j] - x[j-2]) + Math.abs(y[j] - y[j-2]);
                }
                else if (j == not)
                {
                    continue;
                }
                else 
                {
                    cnt += Math.abs(x[j] - x[j-1]) + Math.abs(y[j] - y[j-1]);
                }
            }
            not++;
            ans = Math.min(cnt, ans);

        }
        System.out.print(ans);
    }
}