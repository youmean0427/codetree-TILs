import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        
        int diff = 0;
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int d_idx = 0;
        for (int i = 0; i < 7; i++)
        {
            if (days[i].equals(A))
                d_idx = i;
        }

        diff = days(m2, d2) - days(m1, d1);

        int ans = 0;
        ans = diff / 7;
        if (ans >= 0 && d_idx <= diff % 7)
            ans += 1;

        System.out.print(ans);
    }

    
    public static int days(int m, int d)
    {
        int[] num_of_days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dd = 0;
        for (int i = 1; i < m; i++)
        {
            dd += num_of_days[i];
        }
        dd += d;
        return dd;
    }
}