import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String cold1 = sc.next();
        int temp1 = sc.nextInt();

        String cold2 = sc.next();
        int temp2 = sc.nextInt();

        String cold3 = sc.next();
        int temp3 = sc.nextInt();

        int cnt = 0;


        if (cold1.charAt(0) == 'Y') {
            if (temp1 >= 37) {
                cnt += 1;
            }
        }
        if (cold2.charAt(0) == 'Y') {
            if ( temp2 >= 37) {
                cnt += 1;
            }
        } 
        
        if (cold3.charAt(0) == 'Y') {
            if (temp3 >= 37) {
                cnt += 1;
            }
        }
        

        if (cnt >= 2) {
            System.out.println("E");
        } else{
            System.out.println("N");
        }
    }
}