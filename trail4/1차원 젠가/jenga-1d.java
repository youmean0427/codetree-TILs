import java.util.*;

public class Main {
    public static int[] arr, temp;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();

        temp = new int[n];


        jenga(s1, e1);
        copy();
        jenga(s2, e2);
        copy();

        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
            {
                sum++;
            }        
        }
        
        System.out.println(sum);
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
            {
                System.out.println(arr[i]);
            }
        }
    }

    public static void jenga (int a, int b)
    {
        int tIdx = 0;
        int aIdx = 0;
        while (aIdx < n)
        {
            if (aIdx >= a-1 && aIdx <= b-1)
            {
                aIdx++;
            }
            else 
            {
                temp[tIdx] = arr[aIdx];
                aIdx++;
                tIdx++;
            }
        }
    }

    public static void copy()
    {
        for (int i = 0; i < n; i++)
        {
            arr[i] = temp[i];
        }
    }
}