import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = -1;
        for (int i = 0; i < n-2; i++)
        {
            for (int j = i+1; j < n-1; j++)
            {
                for (int k = j+1; k < n; k++)
                {
                    if (carry(arr[i], arr[j], arr[k])==1)
                    {
                        ans = Math.max(ans, arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }
        System.out.print(ans);
    }

    public static int carry(int a, int b, int c)
    {
        for (int i = 0; i < 5; i++)
        {
            if ( a % 10 + b % 10 + c % 10 >= 10 )
            {
                return 0 ;
            }
            else 
            {
                a /= 10;
                b /= 10;
                c /= 10;
            }
        }
        return 1;
    }
}