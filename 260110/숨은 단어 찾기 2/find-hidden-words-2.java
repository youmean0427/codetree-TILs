import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] sArr = new String[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = sc.next();
        }

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = sArr[i].charAt(j);
            }
        }

        int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] == 'L')
                {
                    for (int dir = 0; dir < 8; dir++)
                    {
                        int ii = i+dx[dir];
                        int jj = j+dy[dir];
                        int cnt = 0;
                        for (int x = 0; x < 2; x++) 
                        {
                            if (ii < 0 || ii >= n || jj < 0 || jj >= m)
                            {
                                break; 
                            }
                            if (arr[ii][jj] == 'E')
                            {
                                cnt++;
                                ii += dx[dir];
                                jj += dy[dir];
                            }
                        }
                        if (cnt == 2)
                        {
                             ans++;
                        }
                    }
                }
            }
        }
        System.out.print(ans);
    }
}