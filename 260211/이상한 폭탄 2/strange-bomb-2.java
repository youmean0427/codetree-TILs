import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i - k; j <= i; j++)
            {
                if (j < 0)
                {
                    break;
                }
                else if (i == j)
                {
                    continue;
                }
                else if (bombs[i] == bombs[j])
                {
                    ans = Math.max(ans, bombs[i]);
                }
            }

            for (int l = i; l <= i + k; l++)
            {
                if (l >= n)
                {
                    break;
                }
                else if (i == l)
                {
                    continue;
                }
                else if (bombs[i] == bombs[l])
                {
                    ans = Math.max(ans, bombs[i]);
                }
            }
        }
        System.out.print(ans);
    }
}