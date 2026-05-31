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

class Rect {
    int x1, y1, x2, y2;

    Rect(Pair a, Pair b) {
        this.x1 = Math.min(a.x, b.x);
        this.x2 = Math.max(a.x, b.x);
        this.y1 = Math.min(a.y, b.y);
        this.y2 = Math.max(a.y, b.y);
    }
}


public class Main {
    public static List<Pair> list = new ArrayList<>();
    public static List<Pair> chList = new ArrayList<>();
    public static int n, m, ans;
    public static int[][] arr, visited;

    public static void main(String[] args) {
        ans = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new int[n][m];

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

    public static void clearVisited() {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                visited[i][j] = 0;
            }
        }
    }


    public static void cal() {
        Rect r1 = new Rect(chList.get(0), chList.get(1));
        Rect r2 = new Rect(chList.get(2), chList.get(3));

        if (isOverlap(r1, r2)) {
            return;
        }

        int sum = 0;

        for (int i = r1.x1; i <= r1.x2; i++) {
            for (int j = r1.y1; j <= r1.y2; j++) {
                sum += arr[i][j];
            }
        }

        for (int i = r2.x1; i <= r2.x2; i++) {
            for (int j = r2.y1; j <= r2.y2; j++) {
                sum += arr[i][j];
            }
        }

        ans = Math.max(ans, sum);
    }

    public static boolean isOverlap(Rect a, Rect b) {
        if (a.x2 < b.x1) return false;
        if (b.x2 < a.x1) return false;
        if (a.y2 < b.y1) return false;
        if (b.y2 < a.y1) return false;

        return true;
    }
}