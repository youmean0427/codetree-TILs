import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int stop = 0;

        for (int i = 0; i < 10; i++)
        {
            arr[i] = sc.nextInt();
            if (arr[i] == 0)
            {
                stop = i;
                break;
            }
            stop = 10;
        }

        for (int j = stop-1; j >= 0; j--)
        {
            System.out.print(arr[j] + " ");
        }
    }
}