import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aMath = sc.nextInt(), aEng = sc.nextInt();
        int bMath = sc.nextInt(), bEng = sc.nextInt();

        if (aMath > bMath) {
            System.out.print("A");
        } else if (bMath > aMath) {
            System.out.print("B");
        } else {
            if (aEng > bEng) {
                System.out.print("A");
            } else 
                System.out.print("B");
            }
        }

    }