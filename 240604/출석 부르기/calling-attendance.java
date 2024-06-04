import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = "Vacancy";
        if (n == 1) {
            name = "John";
        } else if (n == 2) {
            name = "Tom";
        } else if (n == 3) {
            name = "Paul";
        }

        System.out.print(name);
    }
}