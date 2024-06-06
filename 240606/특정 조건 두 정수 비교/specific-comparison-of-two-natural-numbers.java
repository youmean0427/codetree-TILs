import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        
        if (a < b) {
            if (a == b) {
                System.out.println(1 + " " + 1);
            } else {
                System.out.println(1 + " " + 0);
            }
        } else {
            if (a == b) {
                System.out.println(0 + " " + 1);
            } else {
                System.out.println(0 + " " + 0);
            }
        }

    }
}