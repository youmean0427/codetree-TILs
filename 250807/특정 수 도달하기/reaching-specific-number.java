import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int cnt = 0;
        for (int j = 0; j < 10; j++)
        {
            if (arr[j] < 250)
            {
                sum += arr[j];
                cnt += 1; 
            }
            else
            {
                break;
            }
        }

        System.out.printf("%d %.1f", sum, ((double)sum/cnt));
    }
}