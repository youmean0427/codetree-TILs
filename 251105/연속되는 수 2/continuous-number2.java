import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = 1;
        int cnt = 1;
        int now = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (now == arr[i])
            {
                cnt += 1;
            }
            else 
            {
                now = arr[i];
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        System.out.print(ans);
    }
}