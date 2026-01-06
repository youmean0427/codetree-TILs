import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int sum = 0;
                if (i == j || i - 1 == j || i + 1 == j)
                {
                    continue;
                }
                else 
                {
                    sum = arr[i] + arr[j];
                }
                ans = Math.max(ans, sum);
            }
        }
        System.out.print(ans);
    }
}