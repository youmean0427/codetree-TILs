import java.util.Scanner;
public class Main {
    public static int Check(int x, int y)
    {
        if (x == 0 && y == 0)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        
        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        int dir = 0;
        int cnt = 0, ans = -1;
        int x = 0, y = 0;
        for (int i = 0; i < commands.length(); i++)
        {
            if (commands.charAt(i) == 'F')
            {
                x += dirX[dir];
                y += dirY[dir];
            }
            else if (commands.charAt(i) == 'R')
            {
                dir = (dir + 1) % 4;
            }
            else if (commands.charAt(i) == 'L')
            {
                if (dir - 1 < 0)
                    dir = 3;
                else
                    dir -= 1;
            }
            cnt++;

            if (x == 0 && y == 0) {
                ans = cnt;
                break;
            }
        }
        System.out.print(ans);
    }
}