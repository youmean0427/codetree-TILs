import java.util.*;

class Pos {

    int x;
    int y;

    Pos(int a, int b)
    {
        this.x = a;
        this.y = b;
    }
}

public class Main {

    public static List<Pos> list = new ArrayList<>();
    public static List<Pos> box = new ArrayList<>();
    public static int[][] arr;
    public static int sx, sy, ex, ey, ans;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ans = Integer.MAX_VALUE;
        arr = new int[N][N];
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = sc.next();
            for (int j = 0; j < N; j++)
            {
                arr[i][j] = grid[i].charAt(j) - 48;
                // . (-2), S (35), E(21)
                // System.out.print(arr[i][j] + " ");
                if (arr[i][j] >= 1 && arr[i][j] <= 9)
                {
                    list.add(new Pos(i, j));
                }
                if (arr[i][j] == 35)
                {
                    sx = i;
                    sy = j;
                }
                if (arr[i][j] == 21)
                {
                    ex = i;
                    ey = j;
                }
            }
        }
        choose(0, 0); 
        if (ans == Integer.MAX_VALUE)
        {
            System.out.print(-1);
        }
        else 
        {
            System.out.print(ans);
        }
    }

    public static void choose(int idx, int len) {
        if (idx >= 3) 
        {
            int fx = box.get(0).x;
            int fy = box.get(0).y;
            int lx = box.get(box.size()-1).x;
            int ly = box.get(box.size()-1).y;

            len += Math.abs(fx - sx) + Math.abs(fy - sy);
            len += Math.abs(lx - ex) + Math.abs(ly - ey);

            ans = Math.min(ans, len);

            return;
        }

        for (int i = 0; i < list.size(); i++)
        {
            int nx = list.get(i).x;
            int ny = list.get(i).y;

            if (box.size() == 0)
            {
                box.add(new Pos(nx, ny));
                choose(idx+1, len);
                box.remove(box.size()-1);
            }
            else
            {
                int bInd = box.size() - 1;
                int bx = box.get(bInd).x;
                int by = box.get(bInd).y;

                if (arr[bx][by] < arr[nx][ny])
                {
                    box.add(new Pos(nx, ny));
                    choose(idx+1, len+ Math.abs(nx - bx) + Math.abs(ny - by));
                    box.remove(box.size()-1);
                }
            }
        }
    }
}

