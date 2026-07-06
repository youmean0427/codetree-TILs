import java.util.*;

public class Main {
    public static int[][] arr, temp;
    public static int n, m, q;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
            
        arr = new int[n][m]; 
        temp = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                arr[i][j] = sc.nextInt();
                temp[i][j] = arr[i][j];
            }
        }

        for (int cnt = 0; cnt < q; cnt++)
        {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            // math.ceil, math.floor, math.round
            wind(r1, c1, r2, c2);
        }
        arr_print();
    }

    public static void arr_print()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void temp_print()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void wind(int r1, int c1, int r2, int c2)
    {
        
        for (int i = c1-1; i < c2-1; i++)
        {
            temp[r1-1][i+1] = arr[r1-1][i];
        }

        for (int j = r1-1; j < r2-1; j++)
        {
            temp[j+1][c2-1] = arr[j][c2-1];
        }
        
        for (int l = c2-1; l >= c1; l--)
        {
            temp[r2-1][l-1] = arr[r2-1][l];
        }

        for (int k = r2-1; k >= r1; k--)
        {
            temp[k-1][c1-1] = arr[k][c1-1];
        }
        
        avg(r1, c1, r2, c2);
        copy();
    }

    public static int can(int x, int y)
    {
        if (0 <= x && x < n && 0 <= y && y < m)
            return 1;
        return 0;
    }

    public static void copy()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                temp[i][j] = arr[i][j];
            }
        }

    }

    public static void avg(int r1, int c1, int r2, int c2)
    {
        for (int i = r1-1; i < r2; i++)
        {
            for (int j = c1-1; j < c2; j++)
            {
                int sum = temp[i][j];
                int cnt = 1;

                int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
                for (int dirIdx = 0; dirIdx < 4; dirIdx++ )
                {
                    if (can(i + dir[dirIdx][0], j + dir[dirIdx][1]) == 1)
                    {
                        sum += temp[i + dir[dirIdx][0]][j + dir[dirIdx][1]];
                        cnt++;
                    }
                }
                arr[i][j] = (int)(sum/cnt);
            }
        }
    }
}