import java.util.*;
public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int n, k, m;
    public static int[] nums;
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        back(1);

        System.out.print(ans);
        
    }

    public static void back(int cnt) {
        if (cnt > n)
        {
            move();
            return;
        }
        
        for (int i = 1; i <= k; i++)
        {
            list.add(i);
            back(cnt+1);
            list.remove(list.size()-1);
        }
    }

    public static void move()
    {
        int[] location = new int[k+1];
        int score = 0;
        for (int l = 0; l < k+1; l++)
        {
            location[l] = 1;
        }

        for (int idx = 0; idx < n; idx++)
        {
            location[list.get(idx)] += nums[idx]; 
            if (location[list.get(idx)] > m)
            {
                location[list.get(idx)] = m;
            }
        }

        for (int idx = 0; idx < k+1; idx++)
        {
            if (location[idx] == m)
            {
                score++;
            }
        
        }
        ans = Math.max(ans, score);
    }

}