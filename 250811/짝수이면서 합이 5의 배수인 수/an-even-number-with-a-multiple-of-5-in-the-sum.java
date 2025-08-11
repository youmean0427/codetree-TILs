import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(check(n));
    }

    public static String check(int a){
        
        if (a % 2 == 0)
        {
            if ((a / 10 + a % 10) % 5 == 0) {
                return "Yes";
            }
        }
        return "No";
    }
}