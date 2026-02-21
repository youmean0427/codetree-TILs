import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++)
        {
            for (int j = 0; j <= 100; j++)
            {
                int one = 0;
                int two = 0;
                int three = 0;
                int four = 0;

                for (int l = 0; l < n; l++)
                {
                    // one three
                    if (x[l] < i)
                    {
                        // one
                        if (y[l] > j)
                        {
                            one++;
                        }
                        else if (y[l] < j)
                        {
                            three++;
                        }
                    }
                    // two four
                    else if (x[l] > i)
                    {
                        if (y[l] > j)
                        {
                            two++;
                        }
                        else if (y[l] < j)
                        {
                            four++;
                        }

                    }

                    
                }
                if (one + two + three + four == n)
                {
                    int maxValue = Math.max(four, Math.max(three, Math.max(one, two)));
                    // System.out.println(one + " " + two + " " + three + " " + four);
                    ans = Math.min(ans, maxValue);
                }
            }
        }
        System.out.println(ans);
    }
}