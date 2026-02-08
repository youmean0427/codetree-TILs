import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] arr = new int[1001];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();

            for (int j = A[i]; j < B[i]; j++)
            {
                arr[j]++;
            }
        }
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++)
        {
             
            for (int j = A[i]; j < B[i]; j++)
            {
                arr[j]--;
            }

            for (int k = 0; k < 1001; k++)
            {
                if (arr[k] >= 1)
                {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);

            for (int j = A[i]; j < B[i]; j++)
            {
                arr[j]++;
            }
            cnt = 0;

        }

        System.out.print(ans);

    }
}