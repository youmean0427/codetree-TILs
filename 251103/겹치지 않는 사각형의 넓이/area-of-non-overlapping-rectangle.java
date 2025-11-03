import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();
        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        
        int offset = 1000;
        int[][] arr = new int[2000][2000];
        int ans = 0;

        for (int i = offset-ay2; i < offset-ay1; i++)
        {
            for (int j = offset+ax1; j < offset+ax2; j++)
            {
                arr[i][j] = 1;
                ans += 1;
            }
        }

        for (int i = offset-by2; i < offset-by1; i++)
        {
            for (int j = offset+bx1; j < offset+bx2; j++)
            {
                arr[i][j] = 1;
                ans += 1;
            }
        }

        for (int i = offset-my2; i < offset-my1; i++)
        {
            for (int j = offset+mx1; j < offset+mx2; j++)
            {
                if (arr[i][j] == 1)
                    ans -= 1;
            }
        }
        
        System.out.print(ans);
    }
}