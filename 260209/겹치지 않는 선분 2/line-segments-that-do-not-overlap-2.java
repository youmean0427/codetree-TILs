import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] x2 = new int[n];
        int[] x3 = new int[n];
        int[] x4 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            x3[i] = x1[i];
            x4[i] = x2[i];
        }

        Arrays.sort(x3);
        Arrays.sort(x4);

        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (x3[i] == x1[j])
                {
                    if (x2[j] == x4[i])
                    {
                        ans++;
                    }
                } 
            }
            
        }
        System.out.print(ans);
    }
}