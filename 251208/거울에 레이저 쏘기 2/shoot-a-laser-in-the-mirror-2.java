import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();
        
        int max = (n * 4) + 1;
        int[] startX = new int[max];
        int[] startY = new int[max];
        int[] startD = new int[max];

        int idx = 1;
        for (int i = 0; i < n; i++)
        {
            startX[idx] = 0;
            startY[idx] = i;
            startD[idx] = 1;
            idx++;
        }
        for (int i = 0; i < n; i++)
        {
            startX[idx] = i;
            startY[idx] = n-1;
            startD[idx] = 2;
            idx++;
        }
        for (int i = n-1; i >= 0; i--)
        {
            startX[idx] = n-1;
            startY[idx] = i;
            startD[idx] = 3;
            idx++;
        }
        for (int i = n-1; i >= 0; i--)
        {
            startX[idx] = i;
            startY[idx] = 0;
            startD[idx] = 4;
            idx++;
        }

        int sX = startX[startNum];
        int sY = startY[startNum];
        int sD = startD[startNum];

        int[] lTor = new int[]{1, 0, 3, 2};
        int[] rTol = new int[]{3, 2, 1, 0};

        int[] mX = new int[]{0, 1, 0, -1};
        int[] mY = new int[]{1, 0, -1, 0};

        int ans = 0;
        while (sX >= 0 && sX < n && sY >= 0 && sY < n)
        {
            if (grid[sX][sY] == '\\')
            {
                ans += 1;
                sD = lTor[sD];
                sX += mX[sD];
                sY += mY[sD];
            }
            else if (grid[sX][sY] == '/')
            {
                ans += 1;
                sD = rTol[sD];
                sX += mX[sD];
                sY += mY[sD];
            }
        }
        System.out.print(ans);
    }
} 