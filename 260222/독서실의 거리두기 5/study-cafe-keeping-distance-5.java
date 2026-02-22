import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String seat = sc.next();
        
        int[] arr = new int[seat.length()];
        for (int i = 0; i < seat.length(); i++)
        {
            arr[i] = (int)seat.charAt(i) - 48 ;
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 0)
            {
                int len = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++)
                {
                    if (arr[j] == 1)
                    {
                        len = Math.min(len, i - j);
                    }
                }
                for (int j = i + 1; j < n; j++)
                {
                    if (arr[j] == 1)
                    {
                        len = Math.min(len, j - i);
                    }
                }
                ans = Math.max(ans, len);
            }    
        }
        System.out.print(ans);
    }
}