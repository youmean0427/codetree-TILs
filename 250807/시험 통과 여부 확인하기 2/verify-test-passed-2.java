import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[4];
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                arr[j] = sc.nextInt();
            }

            int sum  = 0;
            for (int l = 0; l < 4; l++)
            {
                sum += arr[l];
            }

            if ((sum / 4) >= 60 )
            {
                System.out.println("pass");
                ans += 1;
            }
            else
                System.out.println("fail");
        }
        System.out.print(ans);
    }
}