import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();

        int[][] arr = new int[N][N];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int idx = 0;
        if (D.charAt(0) == 'U')
            idx = 2;
        else if (D.charAt(0) == 'D')
            idx = 0;
        else if (D.charAt(0) == 'R')
            idx = 3;
        else if (D.charAt(0) == 'L')
            idx = 1;

        int sx = R;
        int sy = C;

        while(T > 0)
        {
            sx = sx + dx[idx];
            sy = sy + dy[idx];

            if (sx < 1 || sx > N || sy < 1 || sy > N ) {
                sx -= dx[idx];
                sy -= dy[idx];
                if (idx == 0)
                    idx = 2;
                else if (idx == 2)
                    idx = 0;
                else if (idx == 1)
                    idx = 3;
                else if (idx == 3)
                    idx = 1;
            }
            T--;
        }
        System.out.println(sx + " " + sy);
    }
}