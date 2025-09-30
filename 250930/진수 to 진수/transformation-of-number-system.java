import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();

        int tmp = 0;
        int a = 1;

        for (int i = N.length() - 1; i >= 0; i--)
        {
            tmp += ((int)N.charAt(i) - 48) * a;
            a *= A;
        }

        // System.out.print(tmp);
    
        int[] ans = new int[30];
        int idx = 0;
        while (true)
        {
            if (tmp < B)
            {
                ans[idx] = tmp;
                break;
            }
            ans[idx] = tmp % B;
            tmp /= B;
            idx++;
        }

        for (int i = idx; i >= 0; i--)
        {
            System.out.print(ans[i]);
        }

    }
}