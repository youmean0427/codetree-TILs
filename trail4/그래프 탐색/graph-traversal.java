import java.util.Scanner;
import java.util.ArrayList;

public class Main {
   
    public static int[] visited;
    public static int[][] arr;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        visited = new int[n+1];
        arr = new int[n+1][n+1];
        for (int i = 0; i < m; i++)
        {  
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[x][y] = 1;
            arr[y][x] = 1;

        }
        
        dfs(1);

        int ans = 0;
        for (int i = 2; i < n+1; i++)
        {
            if (visited[i] == 1)
            {
                ans++;
            }
        }
        System.out.print(ans);
    }

    public static void dfs(int idx)
    {
        visited[idx] = 1;

        for (int i = 0; i < n+1; i++)
        {
            if (arr[idx][i] == 1 && visited[i] == 0)
            {
                dfs(i);
            }
        }
    }
}