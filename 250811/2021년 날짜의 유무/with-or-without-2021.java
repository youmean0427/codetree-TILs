import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if (one(m, d) == 1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static int dayCheck(int d, int n)
    {
        if (d > n)
            return 0;
        return 1;
    }

    public static int one(int mon, int day)
    {
        if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
        {
            return dayCheck(day, 31);
        }
        else if (mon == 2)
        {
            return dayCheck(day, 28);
        }
        else if (mon >= 13)
        {
            return 0;
        }
        else 
        {
            return dayCheck(day, 30);
        }
    }
}