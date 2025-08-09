import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNLine(n);
        
    }

    public static void printNLine(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("12345^&*()_");
            System.out.println();
        }
    }
}