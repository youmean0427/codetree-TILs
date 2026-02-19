import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        
        int ans = 0;
        for (int i = 1; i <= 3; i++)
        {
            int[] cups = new int[4];
            int cnt = 0;
            cups[i] = 1;

            for (int j = 0; j <n; j++)
            {
                int tmp = 0;

                tmp = cups[a[j]];
                cups[a[j]] = cups[b[j]];
                cups[b[j]] = tmp;

                if (cups[c[j]] == 1)
                {
                    cnt++;
                }
            }


            ans = Math.max(ans, cnt);


        }
        System.out.print(ans);
    }
}