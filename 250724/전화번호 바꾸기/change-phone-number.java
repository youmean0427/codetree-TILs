import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.next().split("-");
        System.out.print(arr[0] +"-" + arr[2] + "-" + arr[1]);

    }
}