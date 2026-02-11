import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        Gift[] g = new Gift[n+1];

        for (int i = 0; i < n; i++)
        {
            g[i] = new Gift();
            g[i].a = sc.nextInt();
            g[i].b = sc.nextInt();
        }

        Arrays.sort(g, 0, n, (g1, g2) -> Integer.compare(g1.a + g1.b, g2.a + g2.b));

        int ans = 0;
        int cost = 0;
        for (int i = 0; i < n; i++)
        {
            cost = g[i].a / 2 + g[i].b;
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    continue;
                }
                
                cost += g[j].a + g[j].b;

                if (cost <= b)
                {
                    ans =  Math.max(ans, j+1);
                }
            }
        }
        System.out.print(ans);

    }

}

class Gift {
    int a = 0;
    int b = 0;

    public Gift()
    {

    }

    public Gift(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}