import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = a[0]; i <= b[0]; i++)
        {
            int num = i;
            int flag = 0;
            for (int j = 0; j < n; j++)
            {
                num = num * 2;
                if (num >= a[j] && num  <= b[j])
                {
                    continue;
                }
                else
                {
                    flag = 1;
                    break;
                }
            }
        
            if (flag == 0)
            {
                ans = Math.min(ans, i);
            }
        }
        System.out.print(ans);
    }
}