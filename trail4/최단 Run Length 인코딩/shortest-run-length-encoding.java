import java.util.Scanner;

public class Main {
    public static int n, ans;
    public static char[] arr, temp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        n = A.length();
        arr = new char[n];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
        {
            arr[i] = A.charAt(i);
        }
        for (int j = 0; j < n; j++)
        {
            shift();
        }
        System.out.print(ans);
    }

    public static void arrPrint(char[] arr)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void copy()
    {
        for (int i = 0; i < n; i++)
        {
            arr[i] = temp[i];
        }
    }

    public static void shift()
    {
        temp = new char[n];
        temp[0] = arr[n-1];
        for (int i = 0; i < n-1; i++)
        {
            temp[i+1] = arr[i];
        }

        copy();
        encoding();
    }

    public static void encoding()
    {
        int tempAns = 0;
        int cnt = 1;
        
        int i = 0;
        int j = 1;

        while (j <= n-1)
        {
            if (arr[i] == arr[j])
            {
                cnt++;
                j++;
            }
            else 
            {
                if (cnt >= 10)
                {
                    tempAns += 1;
                    tempAns += 2;
                }
                else
                {
                    tempAns += 1;
                    tempAns += 1;
                }
                i = j;
                cnt = 1;
                j++;
            }
        }

        if (cnt >= 10)
        {
            tempAns += 1;
            tempAns += 2;
        }
        else
        {
            tempAns += 1;
            tempAns += 1;
        }

        ans = Math.min(tempAns, ans);
    }
}