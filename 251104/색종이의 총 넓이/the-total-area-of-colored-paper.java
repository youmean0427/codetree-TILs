import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[][] arr = new int[200][200];
        
        int offset = 100;

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();


            for (int j = offset - x[i] - 8 ; j < offset - x[i]; j++)
            {
                for (int k = offset + y[i]; k < offset + y[i] + 8; k++)
                {
                    arr[j][k] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 200; i++)
        {
            for (int j = 0; j < 200; j++)
            {
                if (arr[i][j] == 1)
                    ans += 1;
            }
            
        }
       System.out.print(ans);
    }
}