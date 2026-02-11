import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] board = new int[n+1][n+1];

        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < n-1; j++)
            {
                for (int l = j+1; l < n; l++)
                {
                    board[arr[i][j]][arr[i][l]] = 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <n+1; i++)
        {
            for (int j = 0; j < n+1; j++)
            {
                if (board[i][j] != board[j][i])
                {
                    ans++;
                }    
            }
        }
        System.out.print(ans / 2);
    }
}