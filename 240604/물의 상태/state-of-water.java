import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "water";
        if (n < 0) {
            ans = "ice";
        } else if (n >= 100) {
            ans = "vapor";
        }
        
        System.out.print(ans);

    }
}