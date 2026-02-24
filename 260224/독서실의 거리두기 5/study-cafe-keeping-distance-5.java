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
            int len = Integer.MAX_VALUE;
            if (arr[i] == 0)
            {
                arr[i] = 1;
            
                int prev = -1;
                for (int j = 0; j < n; j++)
                {
                    if (arr[j] == 1 && prev >= 0)
                    {
                        len = Math.min(len, j - prev);
                        prev = j;
                        
                    }
                    else if (arr[j] == 1 && prev == -1)
                    {
                        prev = j;
                    }
                }
                

                // System.out.println();
                arr[i] = 0;
                ans = Math.max(ans, len);
            }
        }
        System.out.print(ans);
    }
}