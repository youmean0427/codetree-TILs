import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        if (dayCheck(m, d, month(y)) == 0)
            System.out.print(-1);
        else
            System.out.print(season(m));
    }

    public static int month(int y) {
        if (y % 4 == 0)
        {
            if (y % 100 == 0)
                return 0;
            else if (y % 100 == 0 && y % 400 == 0)
                return 1;
            else
                return 1;
        }
        return 0;
    }

    public static String season(int m) {
        if (m == 1 || m == 2 || m == 12)
            return "Winter";
        else if (m == 3 || m == 4 || m == 5)
            return "Spring";
        else if (m == 6 || m == 7 || m == 8)
            return "Summer";
        else
            return "Fall";
        
    }

    public static int dayCheck(int m, int d, int check) {
        if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            if (d <= 30)
                return 1;
            else
                return 0;
        }
        else if (m == 2 && check == 1)
        {
            if (d <= 29)
                return 1;
            else
                return 0;
        }
        else if (m == 2 && check == 0)
        {
            if (d <= 28)
                return 1;
            else 
                return 0;
        }
        else
        {
            if (d <= 31)
                return 1;
            return 0;
        }
    }
}

