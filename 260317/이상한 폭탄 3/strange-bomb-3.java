import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];
        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n ; i++)
        {
            int cnt = 1;
            for (int j = 0; j < n; j++)
            {
                if (i != j)
                {
                    if (Math.abs(i - j) <= k)
                    {
                        if (arr[i] == arr[j])
                        {
                            cnt++;
                        }
                    }
                }
            }
            
            if (cnt >= max && cnt > 1)
            {
                max = cnt;
                ans = arr[i];
            }

        }  
        System.out.print(ans);
    }
}