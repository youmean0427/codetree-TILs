import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[M];
        int[] a = new int[M];
        int[] b = new int[M];
        for (int i = 0; i < M; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        
        int ans = 0;

        for (int j = 0; j < M-1; j++)
        {
            arr[j] = 1;
            for (int k = j+1; k < M; k++)
            {
                if (a[j] == a[k] && b[j] == b[k])
                {
                    arr[j]++;
                }
                else if (a[j] == b[k] && a[k] == b[j])
                {
                    arr[j]++;
                }
            }
            ans = Math.max(ans, arr[j]);
        }
        System.out.print(ans);

    }
}