import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        

        int sum = cal(a, o, c);
        if (sum == 999999)
        {
            System.out.print("False");
        }
        else 
        {
            System.out.print(a + " " + o + " " + c + " = " + sum);
        }

    }

    public static int cal(int a, char o, int c) {
        int sum = 999999;
        int flag = 0;
        if (o == '+')
        {
            sum = a + c;
        }
        else if (o == '-')
        {
            sum = a - c;
        }
        else if (o == '/')
        {
            sum = a / c;
        }
        else if (o == '*')
        {
            sum = a * c;
        }
        return sum;
    }

}