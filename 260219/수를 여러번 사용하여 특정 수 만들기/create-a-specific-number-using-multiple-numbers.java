import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        

        int ans = 0;
        for (int i = 0; i <= C / A; i++)
        {
            for (int j = 0; j <= C / B; j++)
            {
                if ( C >= (A * i) + (B * j))
                {
                    ans = Math.max(ans, A * i + B * j); 
                }
            }
        }
        System.out.print(ans);
        
    }
}