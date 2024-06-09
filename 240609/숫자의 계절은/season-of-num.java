import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        String ans = "";
        if (m >= 3 && m <= 5) {
            ans = "Spring";
        } else if (m >= 6 && m <= 8) {
            ans = "Summber";
        } else if (m >= 9 && m <= 11 ){
            ans = "Fall";
        } else {
            ans = "Winter";
        }

        System.out.print(ans);

    }
}