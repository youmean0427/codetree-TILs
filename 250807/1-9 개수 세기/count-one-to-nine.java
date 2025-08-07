import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[9];

        for (int i = 0; i < n; i++)
        {
            arr[sc.nextInt()-1] += 1;
        }

        for (int j = 0; j < 9; j++)
        {
            System.out.println(arr[j]);
        }
    }
}