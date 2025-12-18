import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        char cha = 65;
        
        int dir = 0;
        int cnt = 1;
        int x = 0, y = 0;
        while(cnt < n * m)
        {
            arr[x][y] = cha;            
            if (range(x + dx[dir], y + dy[dir], n, m) == 1)
            {
                if (arr[x + dx[dir]][y + dy[dir]] == 0)
                { 
                    if ((int)cha + 1 >= 91)
                        cha = (char)((((int)cha + 1) % 91) + 65);
                    else 
                        cha = (char)(((int)cha + 1));
                    x = x + dx[dir];
                    y = y + dy[dir];
                    cnt++;
                    continue;
                }
            }
            dir = (dir + 1) % 4;
        }
        arr[x][y] = cha;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

       public static int range(int x, int y, int n, int m)
        {
            if (x >= 0 && x < n && y >= 0 && y < m)
                return 1;
            return 0;
        }

}