import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++)
        {
            
            int ext = 0;

            int wMin = Integer.MAX_VALUE;
            int wMax = 0;
            int hMin = Integer.MAX_VALUE;
            int hMax = 0;

            for (int j = 0; j < N; j++)
            {
                if (i == j)
                {
                    continue;
                }
                
                wMin =  Math.min(x[j], wMin);
                wMax =  Math.max(x[j], wMax);


                hMin = Math.min(y[j], hMin);
                hMax = Math.max(y[j], hMax);

            }
            ans = Math.min(Math.abs(hMax - hMin) * Math.abs(wMax - wMin), ans);
        }
        System.out.print(ans);
    }
}