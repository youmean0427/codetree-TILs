import java.util.*;

public class Main {
    public static int n, m;
    public static int[] A;
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        back(0, 0, 0);
        System.out.print(ans);

    }

    public static void back(int currIdx, int cnt, int result)
    {
        if (currIdx >= n)
        {
            if (cnt == m)
            {
                xor(result);
            }
            return;
        }
        back(currIdx+1, cnt+1, result ^ A[currIdx]);
        back(currIdx+1, cnt, result);
    }

    public static void xor(int result)
    {
        ans = Math.max(ans, result);
    }
}