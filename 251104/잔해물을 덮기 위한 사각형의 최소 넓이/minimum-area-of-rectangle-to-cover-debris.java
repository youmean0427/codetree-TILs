import java.util.Scanner;

public class Main {

    public static final int OFFSET = 1000;
    public static final int[][] ARR = new int[2001][2001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();

        for (int i = OFFSET - rect1_y2; i < OFFSET - rect1_y1; i++)
        {
            for (int j = OFFSET + rect1_x1; j < OFFSET + rect1_x2; j++)
            {
                ARR[i][j] = 1;
            }
        }


        for (int i = OFFSET - rect2_y2; i < OFFSET - rect2_y1; i++)
        {
            for (int j = OFFSET + rect2_x1; j < OFFSET + rect2_x2; j++)
            {
                ARR[i][j] = 0;
            }
        }

        int xMin = 2001;
        int xMax = -1;
        int yMin = 2001;
        int yMax = -1;

        for (int i = 0; i <= 2000; i++)
        {
            for (int j = 0; j <= 2000; j++)
            {
                if (ARR[i][j] == 1)
                {
                    xMin = Math.min(OFFSET-i, xMin);
                    xMax = Math.max(OFFSET-i, xMax);
                    yMin = Math.min(OFFSET-j, yMin);
                    yMax = Math.max(OFFSET-j, yMax);
                }
            }  
        }
        System.out.print((xMax - xMin + 1) * (yMax - yMin + 1));
    } 
}
