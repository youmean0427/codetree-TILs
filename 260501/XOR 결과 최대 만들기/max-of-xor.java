import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
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
        back(0, 0);
        System.out.print(ans);

    }

    public static void back(int currIdx, int cnt)
    {
        if (currIdx >= n)
        {
            if (cnt == m)
            {
                xor();
            }
            return;
        }
        
        list.add(A[currIdx]);
        back(currIdx+1, cnt+1);
        list.remove(list.size()-1);

        back(currIdx+1, cnt);
    }

    public static void xor()
    {
        int num = 0;
        // for (int i = 0; i < list.size(); i++)
        // {
        //     System.out.print(list.get(i));
        // }
        // System.out.println();

        for (int i = 0; i < list.size(); i++)
        {
            num ^= list.get(i);
        }

        ans = Math.max(ans, num);
    }
}