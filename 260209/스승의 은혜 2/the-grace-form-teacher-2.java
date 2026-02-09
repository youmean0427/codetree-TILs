import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        
        // 선물 가격 정렬
        Arrays.sort(p);

        // 작은 것 부터 선택

        int cost = 0;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            cost += p[i];
            for (int j = 0; j <= i; j++)
            {
                cost -= p[j] / 2;
                if (cost <= b)
                {
                    ans = Math.max(ans, i+1);
                }
                cost += p[j] / 2;
            }
        }
        
        System.out.print(ans);
    }
}