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
        
        int max = (n * 4) + 1
        char[] startX = new int[max];
        char[] startY = new int[max];
        char[] startD = new int[max];

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
            startY[idx] = n;
            startD[idx] = 2;
            idx++;
        }
        for (int i = n-1; i >= 0; i--)
        {
            startX[idx] = n;
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


        for (int i = 0; i < (n*4)+1; i++)
        {
            System.out.print(startX[i]);
        }
    }
} 