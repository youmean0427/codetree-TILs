import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        String seat = sc.next();
        for (int i = 0; i < n; i++)
        {
            arr[i] = seat.charAt(i) - '0';
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if (arr[i] == 0 && arr[j] == 0)
                {
                    arr[i] = 1;
                    arr[j] = 1;
                    
                    int a = diff(arr);
                    ans = Math.max(ans, a);
                    arr[i] = 0;
                    arr[j] = 0;
                }

            }
        }
        System.out.print(ans);

    }
    public static int diff(int[] arr)
    {
        int[] diffArr = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 1)
            { 
                diffArr[idx] = i;
                idx++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < idx; i++)
        {
            min = Math.min(diffArr[i] - diffArr[i-1], min);
        }
        return min;
    }
}