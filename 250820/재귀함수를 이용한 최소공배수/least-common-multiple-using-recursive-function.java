import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        F3(1, n, arr);
        System.out.print(arr[n-1]);
    }

    public static int F3(int i, int n, int[] arr)
    {
        if (i >= n)
            return 0;
        arr[i] = F2(arr[i], arr[i-1]);
        return F3(i+1, n, arr);
    }

    public static int F2(int n, int m)
    {
        return (n * m) / F(n, m) ;
    }

    public static int F(int n, int m)
    {
        if (m <= 0)
            return n;
        return F(m, n % m);
    }
}