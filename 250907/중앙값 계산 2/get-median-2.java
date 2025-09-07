import java.util.Scanner;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) 
        {
            temp[i] = arr[i];
            if (i % 2 == 0)
            {
                System.out.print(midValue(temp, i) + " ");
            }
        }
    }

    public static int midValue(int[] temp, int to)
    {
        Arrays.sort(temp, 0, to+1);
        return temp[to/2];
    }
}