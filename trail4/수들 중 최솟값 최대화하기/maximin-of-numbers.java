import java.util.*;
import java.io.*;

public class Main {
    public static int n, ans;
    public static int[] visited;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ans = 0;
        visited = new int[n];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(0, Integer.MAX_VALUE);
        System.out.print(ans);
        
    }

    public static void choose(int idx, int minValue)
    {
        if (idx >= n)
        {
            ans = Math.max(ans, minValue);
            return;
        }

        for (int i = 0; i < n; i++)
        {
            if (visited[i] == 1)
            {
                continue;
            }
            visited[i] = 1;
            choose(idx+1, Math.min(minValue, arr[idx][i]));
            visited[i] = 0;
        }
    }
}