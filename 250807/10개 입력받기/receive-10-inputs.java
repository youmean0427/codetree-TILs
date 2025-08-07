import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < 10; i++)
        {
            int k = sc.nextInt();
            if (k == 0)
                break;
            else
            {
                sum += k;
                cnt += 1;
            }    
        }
        System.out.printf("%d %.1f", sum, ((double)sum/cnt));
    }
}