import java.util.*;

public class Main {
    public static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        memo = new int[n+1];
        System.out.print(fibo(n));
    }

    public static int fibo(int n)
    {
        if (memo[n] != 0)
            return memo[n];
        if (n <= 2)
            return memo[n] = 1;
        return memo[n] = fibo(n-1) + fibo(n-2);
    }
}