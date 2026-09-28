import java.util.*;

class Pos {
    int x;
    int y;

    Pos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

}

public class Main {

    public static int n, sum;
    public static int[][] map, visited;
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static ArrayList<Pos> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1)
                {
                    arr.add(new Pos(i, j));
                }
                
            }
        }

        for (int i = 0; i < arr.size(); i++)
        {
            sum = 0;
            dfs(arr.get(i).x, arr.get(i).y);
            
            if (sum > 0)
            {
                ans.add(sum);
            }
        }

        System.out.println(ans.size());
        ans.sort((a, b) -> a - b);
        for (int i = 0; i < ans.size(); i++)
        {
            System.out.println(ans.get(i));
        }
            
    
    }
    public static int isRange(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < n)
        {
            return 1;
        }
        return 0;
    }

    public static void dfs(int x, int y)
    {
        if (visited[x][y] == 0)
        {
            visited[x][y] = 1;
            sum++;
        }
     
        
        int[][] m = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < 4; i++)
        {
            int nx = x + m[i][0];
            int ny = y + m[i][1];

            if(isRange(nx, ny) == 1)
            {
                if ( map[nx][ny] == 1 && visited[nx][ny] == 0)
                {
                    dfs(nx, ny);
                }
            }
        }
        

    }
}