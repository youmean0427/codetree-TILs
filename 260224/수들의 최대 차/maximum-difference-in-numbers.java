import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            
            int num = arr[i];
            int cnt = 1;
            for (int j = i+1; j < n; j++)
            {
                if (arr[j] - num <= k)
                {
                    cnt++;
                }
                else {
                    break;
                }
            }
            ans = Math.max(ans, cnt);
           
        }
        System.out.println(ans);
    }
}