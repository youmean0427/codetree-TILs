import java.sql.SQLOutput;
import java.util.*;
import java.io.*;


public class Main {
    public static List<Integer> box;
    public static int n, sum, ans;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        n = n * 2;

        arr = new int[n];
        sum  = 0;
        ans = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        choose(0);
        System.out.print(ans);
    }

    public static void choose(int idx)
    {
        if (idx >= n || box.size() == n / 2)
        {
            if (box.size() == n / 2) {
                int subSum = 0;
                for (int j = 0; j < n / 2; j++) {
                    subSum += box.get(j);
                }
                ans = Math.min(ans, Math.abs(subSum - (sum - subSum)));
            }
            return;
        }
        box.add(arr[idx]);
        choose(idx+1);
        box.remove(box.size() - 1);
        choose(idx+1);
    }
}