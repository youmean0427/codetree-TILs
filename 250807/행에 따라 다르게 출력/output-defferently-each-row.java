import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i % 2 != 0)
                {
                    System.out.print(ans + " ");
                    if (j == n)
                        ans += 2;
                    else
                        ans += 1;
                }
                else
                {
                    System.out.print(ans + " ");
                    if (j == n)
                        ans += 1;
                    else
                        ans += 2;
                }
            }

            System.out.println();
        }
    }
}