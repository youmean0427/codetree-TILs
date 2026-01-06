import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) 
        {
            
            int idx = 0;
            int ans = 0;
            int t = i;
            while (idx < n)
            {
                if (t >= n)
                {
                    t = 0;
                }
                ans += arr[t] * (idx);
                idx++;
                t++;
            }
            a = Math.min(a, ans);
        }
        System.out.print(a);
    }
}