import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aMath = sc.nextInt(), aEng = sc.nextInt();
        int bMath = sc.nextInt(), bEng = sc.nextInt();

        if (aMath > bMath && aEng > bEng) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }


    }
}