import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N+1];
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            for (int j = A; j <= B; j++)
            {
                arr[j] += 1;
                if (ans < arr[j])
                    ans = arr[j];
            }
        }

        System.out.print(ans);
        
        
    }
}