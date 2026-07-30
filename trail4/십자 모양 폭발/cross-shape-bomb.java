import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr, temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        arr = new int[n][n];
        temp = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();   

        bomb(r, c);     
    }

    public static boolean canGo(int x, int y)
    {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static void print(int[][] arr)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void copy()
    {
      
        for (int i = 0; i < n; i++)
        {
            int j = n-1;
            int l = n-1; 
            while(l >= 0 && j >= 0)
            {
                if (arr[j][i] == 0)
                {
                    j--;
                }
                else 
                {
                    temp[l][i] = arr[j][i];
                    j--;
                    l--;
                }
            }
        }
    }

    public static void bomb(int r, int c)
    {
        r--;
        c--;

        int cnt = arr[r][c];
        arr[r][c] = 0;
        for (int i = r - (cnt - 1); i <= r + (cnt - 1); i++)
        {
            if (canGo(i, c))
            {
                arr[i][c] = 0;
            }
        }
        for (int i = c - (cnt - 1); i <= c + (cnt - 1); i++)
        {
            if (canGo(r, i))
            {
                arr[r][i] = 0;
            }
        } 

        copy();
        print(temp);       
    }
}