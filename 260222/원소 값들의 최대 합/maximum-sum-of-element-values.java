import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++)
        {
            int sum = arr[i];
            int now = arr[i];
            int cnt = m-1;
            while (cnt > 0)
            {
                now = arr[now];
                sum += now;
                cnt--;
            }

            // System.out.println(sum);
            ans = Math.max(ans, sum);
        }
        System.out.print(ans);
    }
}