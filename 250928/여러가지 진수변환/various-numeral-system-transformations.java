import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] ans = new int[20];
        int idx = 0;

        while (true)
        {
            if (n < b)
            {
                ans[idx] = n;
                break;
            }
            ans[idx] = n % b;
            idx++;
            n /= b;
        }

        for (int i = idx; i >= 0; i--)
        {
            System.out.print(ans[i]);
        }

    }
}