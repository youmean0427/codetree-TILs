import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int i = 0;
        int ans = 0;
        while (i < 2)
        {
            String s = sc.next();
            ans += s.length();
            i++;
        } 
        System.out.print(ans);
    }
}