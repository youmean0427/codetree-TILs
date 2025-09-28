import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
       

        int min = 0;

        int a = 11;
        int b = 11;
        int c = 11;

        if (A < a || (A == 11 && B < b) || (A == 11 && B == 11 && C < c))
            min = -1;
        else
        { 
        while (true)
        {
            if (a == A && b == B && c == C)
                break;
            
            c++;
            min++;

            if (c == 60)
            {
                b++;
                c=0;
            }
            if (b == 24)
            {
                a++;
                b=0;
            }
        }
        }
        System.out.print(min);
    }
}