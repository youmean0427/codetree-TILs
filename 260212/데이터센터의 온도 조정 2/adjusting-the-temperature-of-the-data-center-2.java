import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
        }
        Arrays.sort(ta);
        Arrays.sort(tb);

        int max = Math.max(ta[n-1], tb[n-1]);
        int min = Math.min(ta[0], tb[0]);
        int ans = 0;
        for (int i = min-1; i <= max+1; i++)
        {
            int work = 0;
            for (int j = 0; j < n; j++)
            {

                if (i < ta[j])
                    work += c;
                else if (i >= ta[j] && i <= tb[j])
                    work += g;
                else if (i > tb[j])
                    work += h;
            }
            ans = Math.max(work, ans);
   

        }
        System.out.print(ans);

    }
}