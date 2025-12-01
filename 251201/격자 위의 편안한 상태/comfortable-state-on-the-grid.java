import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] dirX = new int[]{0, 1, -1, 0};
        int[] dirY = new int[]{1, 0, 0, -1};
        int cnt;

        int[][] arr = new int[n][n];
        for (int i = 0; i < m; i++)
        {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            arr[x][y] = 1;
            cnt = 0;
            for (int j = 0; j < 4; j++)
            {
                if (x + dirX[j] >= 0 && x + dirX[j] < n && y + dirY[j] >= 0 && y + dirY[j] < n)
                {
                    if (arr[x + dirX[j]][y + dirY[j]] == 1)
                        cnt++;
                }
            }

            if (cnt == 3)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}