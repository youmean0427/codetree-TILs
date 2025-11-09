import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[2001];
        int[] b = new int[2001];
        int n = sc.nextInt();
        int m = sc.nextInt();

        int offset = 1000;
        int aStart = 1000;
        int bStart = 1000;
        int time = 1;
        for (int i = 0; i < n; i++)
        {
            char c = sc.next().charAt(0);
            int t = sc.nextInt();

            if (c == 'R')
            {
                for (int j = aStart; j < t +offset; j++)
                {
                    a[j] = time;
                    time++;
                }
                aStart = t + offset;
            }
            else
            {
                for (int j = aStart; j > aStart - t; j--)
                {
                    a[j] = time;
                    time++;
                }
                aStart = aStart  - t;
            }
            
            for (int k = 1000; k <= 1012; k++)
            {
                System.out.print(a[k] + " ");
            }
        }

        // for (int i = 1000; i <= 1012; i++)
        // {
        //     System.out.print(a[i] + " ");
        // }
        
        

    }
}