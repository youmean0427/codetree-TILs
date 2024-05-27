import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt() + 8;
        int col = sc.nextInt() * 3;

        System.out.print((row) + "\n" + (col) + "\n" + (row*col));
    }
}