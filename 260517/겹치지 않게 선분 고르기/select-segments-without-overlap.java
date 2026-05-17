import java.util.*;

public class Main {

    public static List<Line> list = new ArrayList<>();
    public static int[] visited;
    public static int n;
    public static int ans;
    public static Line[] lines;

    static class Line {
        int x;
        int y;

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[1001];
        lines = new Line[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        dfs(0, 0);
        System.out.println(ans);   
    }

    public static void dfs(int cnt, int now) {

        ans = Math.max(cnt, ans);

        for (int i = now; i < n; i++) {
            
            boolean possible = true;
            for (int j = lines[i].x; j <= lines[i].y; j++)
            {
                if (visited[j] == 1)
                {
                    possible  = false;
                    for (int k = lines[i].x; k <= j; k++)
                    {
                        visited[k] = 0;
                    }
                    break;
                }
                visited[j] = 1;
            } 

            if (!possible)
            {
                continue;
            }

            list.add(new Line(lines[i].x, lines[i].y));
            dfs(cnt+1, i+1);
            list.remove(list.size()-1);

            for (int j = lines[i].x; j <= lines[i].y; j++)
            {
                visited[j] = 0;
            }              
        }
    }
}
