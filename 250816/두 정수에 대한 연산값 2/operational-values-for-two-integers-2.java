import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int[] arr = new int[2];
        arr[0] = a;
        arr[1] = b;

        swap(arr);
        System.out.print(arr[0] + " " + arr[1]);
    }


    public static void swap(int[] arr)
    {
        if (arr[0] >= arr[1])
        {
            arr[0] *= 2;
            arr[1] += 10;
        }
        else 
        {
            arr[0] += 10;
            arr[1] *= 2;
        }
    }
}