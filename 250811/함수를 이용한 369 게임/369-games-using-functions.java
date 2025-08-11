import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.print(forLoop(A, B));
    }

    public static int forLoop(int a, int b)
    {
        int ans = 0;
        for (int i = a; i <= b; i++)
        {
            ans += find369(i);
        }
        return ans;
    }

    public static int find369(int n)
    {
        if (n % 3 == 0)
            return 1;
        while (n >= 1)
        {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
            {
                return 1;
            } 
            else {
                n /= 10;
            }
        }
        return 0;
    }
}