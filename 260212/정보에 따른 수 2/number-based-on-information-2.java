import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[b+1];
        for (int i = 0; i < T; i++) {
            char c = sc.next().charAt(0);
            int pos = sc.nextInt();
            
            arr[pos] = c;
        }
        // S = 83, N = 78
        int ans = 0;
        for (int i = a; i <= b; i++)
        {
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;
            for (int j = 1; j <= b; j++)
            {
                if (arr[j] == 83)
                {
                    d1 = Math.min(d1, Math.abs(i-j));
                }
                else if (arr[j] == 78)
                {
                    d2 = Math.min(d2, Math.abs(i-j));
                }
            }
            
            if (d1 <= d2)
            {
                ans++;
            }
        }
        System.out.print(ans);
    }
}