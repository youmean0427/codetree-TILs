import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        

        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] r_days = new String[]{"Tue", "Mon", "Sun", "Sat", "Fri", "Thu", "Wed"};

        int dd = 0;
        if (m2 < m1 )
        {

            for (int i = m2; i < m1; i++)
            {
                dd += num_of_days[i];
            }

            dd -= d2;
            dd += d1;
            System.out.print(r_days[(dd+1) % 7]);
        }
        else if (m2 == m1)
        {
            if (d1 > d2)
            {
                System.out.print(r_days[(d1 - d2 + 1) % 7]);
            }
            else
            {
                System.out.print(days[(d2 - d1 + 1) % 7]);
            }
        }
        else
        {
            for (int i = m1+1; i < m2; i++)
            {
                dd += num_of_days[i];
            }

            dd += d2;
            dd += num_of_days[m1] -d1; 
            System.out.print(days[(dd+1) % 7]);
        }
    }
}