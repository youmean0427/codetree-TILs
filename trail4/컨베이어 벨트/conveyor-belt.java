import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int nn = n * 2;
        int[] arr = new int[nn];
        for (int i = 0; i < nn; i++)
        {
            arr[i] = sc.nextInt();
        } 
        
        for (int i = 0; i < t; i++)
        {
            int tmp = arr[nn - 1];

            for (int j = nn - 1; j > 0; j--)
            {
                arr[j] = arr[j-1];
            }
            arr[0] = tmp;
        }

        for (int k = 0 ; k < n; k++)
        {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
        for (int k = n ; k < nn; k++)
        {
            System.out.print(arr[k] + " ");
        }
    }
}