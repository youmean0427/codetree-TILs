import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int aAge = sc.nextInt();
        String aGen = sc.next();
        char aG = aGen.charAt(0);
        int bAge = sc.nextInt();
        String bGen = sc.next();
        char bG = bGen.charAt(0);
        
        if ((aAge >= 19 && aG == 'M') || (bAge >= 19 && bG == 'M')) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

    }
}