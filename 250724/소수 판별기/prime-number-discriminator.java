import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char ans = 'P';
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                ans = 'C';
                break;
            }
        }
        System.out.print(ans);
    }
}