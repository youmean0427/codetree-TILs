import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next();

        String[] arr = time.split(":");
        System.out.print((Integer.parseInt(arr[0]) + 1) + ":" + arr[1]);
    }
}