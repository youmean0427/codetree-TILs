import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int check = 1;
        if (arr[0] < 0)
            check = -1;
        
        int now = arr[0];
        int cnt = 1;
        int ans = 1;
        for (int i = 1; i < n; i++)
        {
            if ((check == -1 && arr[i] < 0) || (check == 1 && arr[i] > 0))
            {
                cnt++;
            }
            else if (check == -1 && arr[i] > 0)
            {
                now = arr[i];
                cnt = 1;
                check = 1;
            }
            else if (check == 1 && arr[i] < 0)
            {
                now = arr[i];
                cnt = 1;
                check = -1;
            }
            ans = Math.max(ans, cnt);
        }
        
        System.out.print(ans);
    }
}