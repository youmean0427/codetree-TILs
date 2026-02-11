import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        int S = sc.nextInt();
        int[][] cheese = new int[D+1][3];
        int[][] cheeseEat = new int[M+1][N+1];
        for (int i = 0; i < D; i++) {
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            
            cheese[i][0] = p;
            cheese[i][1] = m;
            cheese[i][2] = t;
        }

        int[] cnt = new int[M+1];
        for (int i = 0; i < D; i++)
        {
            if (cheeseEat[cheese[i][1]][cheese[i][0]] == 0)
            {
                cheeseEat[cheese[i][1]][cheese[i][0]] = 1;
                cnt[cheese[i][1]]++;
            }
        }

        int ans = 0;
        for (int i = 0; i < S; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();


            for (int j = 0; j < D; j++)
            {
                if (cheese[j][0] == p)
                {
                    if (cheese[j][2] < t)
                    {
                        ans = Math.max( ans, cnt[cheese[j][1]]);
                    }
                }
            }


        }
        
        System.out.print(ans);

        
    }
}