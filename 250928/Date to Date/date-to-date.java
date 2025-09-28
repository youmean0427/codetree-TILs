import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day_count = 1;

        while(m1 != m2 || d1 != d2)
        {
            d1++;
            day_count++;

            if (d1 == num_of_days[m1])
            {
                if (m1 == 12)
                    m1 = 1;
                else
                    m1++;
                d1=0;
            }
        }    

        System.out.print(day_count);
    }
}