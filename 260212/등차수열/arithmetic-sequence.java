import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = 0;
        for (int k = 0; k <= 100; k++)
        {
            int cnt = 0;
            for (int i = 0; i < n-1; i++)
            {
                for (int j = i+1; j < n; j++)
                {
                    if (Math.abs(k - arr[i]) == Math.abs(k - arr[j]))
                    {
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.print(ans);
    }
}