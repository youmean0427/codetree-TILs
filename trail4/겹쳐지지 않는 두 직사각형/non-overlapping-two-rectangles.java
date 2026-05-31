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
    public static List<Pair> chList = new ArrayList<>();
    public static int n, m, ans;
    public static int[][] arr;

    public static void main(String[] args) {
        ans = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                list.add(new Pair(i, j));
            }
        }
        dfs(0);
        System.out.print(ans);
    }

    public static void dfs(int cnt) {
        if (chList.size() == 4) {
            cal();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            chList.add(list.get(i));
            dfs(cnt + 1);
            chList.remove(chList.size() - 1);
        }
    }

    public static void cal() {

        int ax = chList.get(0).x;
        int ay = chList.get(0).y;
        int bx = chList.get(1).x;
        int by = chList.get(1).y;
        int cx = chList.get(2).x;
        int cy = chList.get(2).y;
        int dx = chList.get(3).x;
        int dy = chList.get(3).y;

        int minX1 = Math.min(ax, bx);
        int maxX1 = Math.max(ax, bx);
        int minY1 = Math.min(ay, by);
        int maxY1 = Math.max(ay, by);
        int minX2 = Math.min(cx, dx);
        int maxX2 = Math.max(cx, dx);
        int minY2 = Math.min(cy, dy);
        int maxY2 = Math.max(cy, dy);

        int overlap = 1;

        if (maxX2 < minX1)
            overlap = 0;
        if (minX2 > maxX1)
            overlap = 0;
        if (minY2 > maxY1)
            overlap = 0;
        if (maxY2 < minY1)
            overlap = 0;

        if (overlap == 1)
            return;

        int sum = 0;

        for (int i = minX1; i <= maxX1; i++) {
            for (int j = minY1 ; j <= maxY1; j++) {
                sum += arr[i][j];
            }
        }

        for (int i = minX2; i <= maxX2; i++) {
            for (int j = minY2; j <= maxY2; j++) {
                sum += arr[i][j];
            }
        }
        ans = Math.max(ans, sum);
    }

}