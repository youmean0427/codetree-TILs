import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 5) {
            System.out.print("A");
        }
        else if (a % 2 == 0) {
            System.out.print("B");
        }
        
    }
}