import java.util.Scanner;
public class Main {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        func(m, arr);
        System.out.print(ans);
    }

    public static void func(int cnt, int[] arr){
        ans = arr[cnt];

        while(cnt > 1)
        {
            if (cnt % 2 == 0)
            {
                cnt /= 2;
            }
            else
            {
                cnt -= 1;
            }
            ans += arr[cnt];
        }
    }
}