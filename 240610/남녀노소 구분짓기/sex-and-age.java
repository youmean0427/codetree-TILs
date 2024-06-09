import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int a = sc.nextInt(); 

        if (a >= 19) {
            if (g == 0) {
                System.out.print("MAN");
            } else {
                System.out.print("WOMAN");
            }
        } else {
            if (g == 0) {
                System.out.print("BOY");
            } else {
                System.out.print("GIRL");
            }
            
        }
    }
}