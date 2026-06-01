import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int nn = n * 3;
        int[] arr = new int[nn];

        for (int i = 0; i < nn; i++)
        {
            arr[i] = sc.nextInt();
        }

        for (int j = 0; j < t; j++)
        {
        int tmp = arr[nn - 1];
        for (int i = nn - 1; i > 0; i--)
        {
            arr[i] = arr[i - 1];
        }
        arr[0] = tmp;
        }
        
        for (int i = 0; i < nn; i++)
        {       
            if (i != 0 && i % 3 == 0)
                System.out.println();
            System.out.print(arr[i] + " ");
      
        }
    }
}