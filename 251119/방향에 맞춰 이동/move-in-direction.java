import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int x = 0, y = 0;
        int didx = 0;
        // E : 0, W : 2, N : 1, S : 3
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            if (direction == 'E')
                didx = 0;
            else if (direction == 'N')
                didx = 3;
            else if (direction == 'W')
                didx = 2;
            else if (direction == 'S')
                didx = 1;
            
            x += dx[didx] * distance;
            y += dy[didx] * distance;
  
        }
         System.out.print(x + " " + y);
    }
}