import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static List<Pair> list = new ArrayList<>();
    public static Pair[] arr;
    public static int ans;
    public static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
            {  
                grid[i][j] = sc.nextInt();
                list.add(new Pair(i, j));
            }
        ans = -1;
        arr = new Pair[2];        
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int idx, int lInd)
    {
        if (idx == 2)
        {
            cal();
            return;
        }

        for(int i = lInd; i < list.size(); i++)
        {
            arr[idx] = list.get(i);
            dfs(idx+1, i); //
        }
    }

    public static void cal() 
    {
        
        int sx = arr[0].x;
        int sy = arr[0].y;
        int ex = arr[1].x;
        int ey = arr[1].y;
        int sum = 0;

        for (int i = Math.min(sx, ex); i <= Math.max(sx, ex); i++)  //
        {
            for (int j = Math.min(sy, ey); j <= Math.max(sy, ey); j++)
            {
                if (grid[i][j] > 0)
                {
                    sum += 1;
                }
                else
                {
                    return;
                }
            }
        }
        
        ans = Math.max(ans, sum);


    }
}