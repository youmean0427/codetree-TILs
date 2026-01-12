import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            int cnt = 0;
            double avg = 0;
            for (int j = i; j <n; j++)
            {
                sum += arr[j];
                cnt += 1;

                avg = (double)sum / (double)cnt;

                for (int k = i; k < i+cnt; k++)
                {
                    if (arr[k] == avg)
                    {
                        ans++;
                        break;
                    }
                }
                // System.out.println(avg + " " + sum + " " + cnt);
            }
        }
        System.out.print(ans);
    }
}