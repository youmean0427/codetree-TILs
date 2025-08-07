import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 1;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (i % 2 != 0)
                {    
                    System.out.print(ans);
                    ans+=1;
                }
                else
                {
                    System.out.print(ans);
                    ans-=1;
                }
            }
            
            System.out.println();
            if (i % 2 != 0)
                ans = ans - 1 + n;
            else
                ans = ans + 1 + n;
        }
    }
}