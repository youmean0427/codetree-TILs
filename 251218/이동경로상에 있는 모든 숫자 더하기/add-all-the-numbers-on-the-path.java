import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int T = sc.nextInt();

        String str = sc.next();

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }


        
        int x = (N - 1) / 2;
        int y = (N - 1) / 2;
        int ans = arr[x][y];
        
        int dir = 0;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        

        for (int k = 0; k < T; k++)
        {
            if (str.charAt(k) == 'R')
                dir = (dir + 1) % 4;
            else if (str.charAt(k) == 'L')
            {
                dir = (dir - 1);
                if (dir == -1)
                    dir = 3;
            }
            else if (str.charAt(k) == 'F')
            {
                if (x + dx[dir] >= 0 && x + dx[dir] < N && y + dy[dir] >= 0 && y + dy[dir] < N)
                {
                    x = x + dx[dir];
                    y = y + dy[dir];
                    ans += arr[x][y];
                }
            }
        }

        System.out.print(ans);
    }
}