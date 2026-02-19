import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            arr[i] *= 2;

            for (int j = 0; j < n; j++)
            {
                int cnt = 0;
                for (int k = 0; k < n-1; k++)
                {
                    for (int l = 1; l < n; l++)
                    {
                        if (k != l)
                        {
                            if (k != j && l != j)
                            {
                                cnt += Math.abs(arr[l] - arr[k]);
                                k = l;
                            }
                            

                        }
                    }
                }
                ans = Math.min(ans, cnt);
     
            }
            arr[i] /= 2;
        }
        System.out.print(ans);
    }
}