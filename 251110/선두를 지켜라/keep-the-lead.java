import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }
        int[][] B = new int[m][2];
        for (int i = 0; i < m; i++) {
            B[i][0] = sc.nextInt();
            B[i][1] = sc.nextInt();
        }
        
        int[] aTime = new int[1000001];
        int[] bTime = new int[1000001];

        int now = 1;
        for (int i = 0; i <n; i++)
        {
            for (int j = 0; j <A[i][1]; j++)
            {
                aTime[now] = aTime[now - 1] + A[i][0]; 
                now++;
            }
        } 

        now = 1;
        for (int i = 0; i <m; i++)
        {
            for (int j = 0; j <B[i][1]; j++)
            {
                bTime[now] = bTime[now - 1] + B[i][0]; 
                now++;
            }
        } 

        int flag = 0;
        int ans = 0;
        for (int i = 0; i < now; i++)
        {
            if (aTime[i] > bTime[i])
            {
                if (flag == 2)
                {
                    ans++;
                }    
                flag = 1;
            }
            else if (bTime[i] > aTime[i])
            {
                if (flag == 1)
                {
                    ans++;
                }
                flag = 2;
            }
        }
        System.out.print(ans);
    }
}