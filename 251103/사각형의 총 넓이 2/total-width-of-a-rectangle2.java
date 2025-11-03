import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        int[][] arr = new int[200][200];

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

            for (int j = 100+y1[i]; j <= 100+y2[i]-1; j++)
            {
                for (int l = 100+x1[i]; l <= 100+x2[i]-1; l++)
                {
                    arr[j][l] = 1;
                }
            }

        }
        
        int ans = 0;
        for (int i = 0; i < 200;i++)
        {
            for (int j = 0; j < 200; j++)
            {
                ans += arr[i][j];
            }
        }
        System.out.print(ans);
    }
}