import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        // 최대값을 먼저 지정
        for (int i = Math.max(arr[0], arr[n-1]); i <= 100; i++)
        {
            
            int[] visited = new int[n];
            int idx = 0;
            for (int j = 0; j < n; j++)
            {
                if (arr[j] <= i)
                {
                    visited[idx] = j;
                    idx++;
                }
            }
            int flag = 0;
            for (int l = 1; l < idx; l++)
            {
                if (visited[l]  - visited[l-1] <= k)
                {
                    flag = 1;
                }
                else
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
            {
                ans =  Math.min(i, ans);
            }

        }
        System.out.println(ans);
    }
}