import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print(F(n-1, arr));
       
    }

    public static int F(int n, int[] arr)
    {
        if (n == 0)
            return arr[0];

        if (F(n-1, arr) < arr[n] )
            return arr[n];
        else
            return F(n-1, arr);        

    }
}