import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        
        int ans = 0;
        
        int sum = 0;
        int si = 0, sj = 0;
        int back = 0, back1 = 0, back2 = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n-2; j++)
            {
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                back = arr[i][j]; back1 = arr[i][j+1]; back2 = arr[i][j+2];
                arr[i][j] = 9; arr[i][j+1] = 9; arr[i][j+2] = 9;
         
                for (int ii = 0; ii < n; ii++)
                {
                    for (int jj = 0; jj < n-2; jj++)
                    {
                        if (arr[ii][jj] <= 1 && arr[ii][jj+1] <= 1 && arr[ii][jj+2] <= 1)
                        {
                            int tmp = arr[ii][jj] + arr[ii][jj+1] + arr[ii][jj+2];
                            sum += tmp;
                            ans = Math.max(ans, sum);
                            sum -= tmp;
                        }
                       
                    }
                }
                arr[i][j] = back; arr[i][j+1] = back1; arr[i][j+2] = back2;
            }
        }
        System.out.print(ans);
    }
}