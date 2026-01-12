import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
        {
            B[i] = sc.nextInt();
        }


        int ans = 0;
        for (int i = 0; i <= N-M; i++)
        {
            int cIdx = 0;
            int[] C = new int[M];
            for (int j = i; j < i+M; j++)
            {
                C[cIdx] = A[j];
                cIdx++;
            }

            Arrays.sort(C);
            Arrays.sort(B);
            int cnt = 0;
            for (int k = 0; k < M; k++)
            {
                if (C[k] == B[k])
                {
                    cnt++;
                }
                else 
                {
                    break;
                }
            }
            if (cnt == M)
            {
                ans++;
            }
            
        }
        System.out.print(ans);
        
    }
}