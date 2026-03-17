import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n-2; i++)
        {
     
            for (int j = 0; j < n-2; j++)
            {
                int sum =0 ;
                sum += arr[i][j] + arr[i+1][j] + arr[i+2][j];
                sum += arr[i][j+1] + arr[i][j+2];
                sum += arr[i+1][j+1] + arr[i+2][j+2];
                sum += arr[i+1][j+2] + arr[i+2][j+1];
                ans = Math.max(ans, sum);
            }

            
        }
        System.out.print(ans);
    }
}