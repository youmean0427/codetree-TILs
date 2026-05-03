import java.util.*;

public class Main {
    public static int[] step;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step = new int[n+2];

        step[0] = 1;
        step[1] = 0;
        step[2] = 1;
        step[3] = 1; 

        for (int i = 4; i <= n; i++)
        {
            step[i] = (step[i-2] + step[i-3]) % 10007;
        }
        System.out.print(step[n]);
    }
}