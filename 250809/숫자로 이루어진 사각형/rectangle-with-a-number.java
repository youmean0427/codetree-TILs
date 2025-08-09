import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numberSquare(n);
    }

    public static void numberSquare(int n)
    {
        int ans = 1;
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
            {
                System.out.print(ans + " ");
                ans += 1;

                if (ans == 10)
                    ans = 1;
            }
            System.out.println();
        }
    }
}