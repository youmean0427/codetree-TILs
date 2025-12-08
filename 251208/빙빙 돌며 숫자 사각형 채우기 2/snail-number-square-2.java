import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] arr = new int[n][m];
        
        int x = 0;
        int y = 0;
        int cnt = 1;
        arr[x][y] = cnt;
        int d = 0;
        cnt++;
        
        while (cnt <= n * m) {
            
            if (d == 0)
            {
                x++;
            }
            else if (d == 1)
            {
                y--;
            }
            else if (d == 2)
            {
                x--;
            }
            else if (d == 3)
            {
                y++;
            }

            if (check(x, y, n, m) == 1)
            {
                if (arr[x][y] == 0)
                {
                    arr[x][y] = cnt;
                    cnt++;
                    continue;
                }
            }
          
            if (d == 0)
            {
                d = 3;
                x--;
            }
            else if (d == 1)
            {
                d = 0;
                y++;
            }
            else if (d == 2)
            {
                d = 1;
                x++;
            }
            else if (d == 3)
            {
                d = 2;
                y--;
            }
            
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

    public static int check(int x, int y, int n, int m)
    {
        if (x >= 0 && x < n && y >= 0 && y < m)
            return 1;
        return 0;
    }
}