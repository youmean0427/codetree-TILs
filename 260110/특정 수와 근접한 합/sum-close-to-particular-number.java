import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i != j)
                {
                    int sum = 0;
                    for (int k = 0; k < n; k++)
                    {
                        if (k != i && k != j)
                            sum += arr[k];
                    }
                    ans = Math.min(ans, Math.abs(sum - s));
                }
            }
        }
        System.out.print(ans);

    }
}