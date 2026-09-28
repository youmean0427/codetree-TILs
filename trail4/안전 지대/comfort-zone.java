import java.util.*;
public class Main {
    public static int n, m;
    public static int[][] map, waterMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        waterMap = new int[n][m];

        int waterMax = 0;

        int ansTown = 0;
        int ansWater = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                map[i][j] = sc.nextInt();
                waterMax = Math.max(waterMax, map[i][j]);
            }
        }
        
        for (int w = 1; w <= waterMax; w++)
        {
            int town = 0;
            int[][] visited = new int[n][m];
            waterMap = new int[n][m];

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (map[i][j] > w)
                    {
                        waterMap[i][j] = 1;
                    }
                }
            }
            
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (visited[i][j] == 0 && waterMap[i][j] == 1)
                    {
                        town++;
                        dfs(i, j, visited, waterMap); 
                    }
                }
            }

            if (ansTown < town || (ansTown == town && w < ansWater))
            {
                ansWater = w;
                ansTown = town;
            }
        }

        System.out.print(ansWater + " " + ansTown);
    }

    public static int isRange(int x, int y)
    {
        if (x >= 0 && x < n && y >= 0 && y < m)
        {
            return 1;
        }
        return 0;
    }

    public static void dfs(int x, int y, int[][] visited, int[][] waterMap)
    {
        
        int[][] pos = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int idx = 0; idx < 4; idx++)
        {
            int nx = x + pos[idx][0];
            int ny = y + pos[idx][1];

            if (isRange(nx, ny) == 1)
            {
                if (waterMap[nx][ny] == 1 && visited[nx][ny] == 0)
                {
                    visited[nx][ny] = 1;
                    dfs(nx, ny, visited, waterMap);
                }
            }
        }
    }

    public static void print(int[][] arr)
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
}