import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[201][201];

        int offset = 100;
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            {
                for (int l = offset - y2; l < offset - y1; l++)
                {
                    for (int j = offset + x1; j < offset + x2 ; j++)
                    {
                        if (i % 2 == 0)
                            arr[l][j] = 1;
                        else
                            arr[l][j] = 2;    
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= 200; i++)
        {
            for (int j = 0; j <= 200; j++)
            {
                if (arr[i][j] == 2)
                    ans += 1;
                // System.out.print(arr[i][j]);
            }
        }
        System.out.print(ans);
    }
}