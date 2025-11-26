import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        int num = 1;
        int sx = 0, sy = 0;
        
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int dir = 0;
        
        while(num <= n * m)
        {
            arr[sx][sy] = num;

            if (0 <= sx+dx[dir] && sx+dx[dir] < n && 0 <= sy+dy[dir] && sy+dy[dir] < m) {
                if (arr[sx+dx[dir]][sy+dy[dir]] != 0) {
                    dir = (dir + 1) % 4;
                } 
            }
            else 
            {
                dir = (dir + 1) % 4;
            }
            sx += dx[dir];
            sy += dy[dir];
            num++;
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}