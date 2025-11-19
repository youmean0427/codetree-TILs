import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int direction = 3;
        int x = 0, y = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ss = s.charAt(i);
            if (ss == 'F')
            {
                x += dx[direction];
                y += dy[direction];
            }
            else if (ss == 'R')
            {
                direction = (direction + 1) % 4;
            }
            else if (ss == 'L')
            {
                direction = (direction - 1 + 4) % 4;
            }
        }
        
        System.out.print(x + " " + y);

    }
}