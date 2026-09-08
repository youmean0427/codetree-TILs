import java.util.*;
public class Main {

    static class Position {
        int x;
        int y;

        Position(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Position> list = new ArrayList<>();
    public static List<Integer> select = new ArrayList<>();
    public static int[] visitedX, visitedY;
    public static int[][] grid;
    public static int n, ans;

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = 0;
        visitedX = new int[n];
        visitedY = new int[n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = sc.nextInt();
                list.add(new Position(i, j));
                
            }
        choose(0, 0);
        System.out.print(ans);
    }

    public static void choose(int cnt, int start)
    {
        if (cnt == n)
        {   
            answerPrint();
            return;
        }

        for (int i = start; i < start + n; i++)
        {
            int nx = list.get(i).x;
            int ny = list.get(i).y;

            if (visitedX[nx] == 1 || visitedY[ny] == 1)
                continue;

            visitedX[nx] = 1;
            visitedY[ny] = 1;
            select.add(grid[nx][ny]);
            choose(cnt + 1, start + n);
            select.remove(select.size()-1);
            visitedX[nx] = 0;
            visitedY[ny] = 0;
        }
    }

    public static void answerPrint()
    {
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += select.get(i);
        }
        ans = Math.max(ans, sum);
    }
}