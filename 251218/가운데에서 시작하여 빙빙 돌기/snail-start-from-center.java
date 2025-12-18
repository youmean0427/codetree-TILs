import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] arr = new int[n][n];

        int x = n - 1;
        int y = n - 1;
        int num = n * n;

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        int dir = 0;

        while (num >= 1)
        {
            arr[x][y] = num;
            if (num == 1)
                break;

            if (x + dx[dir] >= 0 && x + dx[dir] < n && y + dy[dir] >= 0 && y + dy[dir] < n)
            {
                if (arr[x + dx[dir]][y+ dy[dir]] == 0)
                {
                    x = x + dx[dir];
                    y = y + dy[dir];
                    num--;
                    continue;
                }
            }
            dir = (dir + 1) % 4;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}