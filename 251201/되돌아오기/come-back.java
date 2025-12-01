import java.util.Scanner;


public class Main {
    
    public static int Check(int x, int y)
    {
        if (x==0 && y==0)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0, ans = -1;
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
        
        if (dir == 'N')
        {
            while (dist-- > 0)
            {
                y++;
                cnt++;
                if (Check(x, y) == 1)
                {
                    System.out.print(cnt);
                    return;
                }
            }
        }
        else if (dir == 'S')
        {
            while (dist-- > 0)
            {
                y--;
                cnt++;
                if (Check(x, y) == 1){
                    System.out.print(cnt);
                    return;
                }
            }
        }
        else if (dir == 'E')
        {
            while (dist-- > 0)
            {
                x++;
                cnt++;
                if (Check(x, y) == 1){
                    System.out.print(cnt);
                    return;
                }
            }
        }
        else if (dir == 'W')
        {
            while (dist-- > 0)
            {
                x--;
                cnt++;
                if (Check(x, y) == 1){
                    System.out.print(cnt);
                    return;
                }
            }
        }
        }
        System.out.print(-1);
    }
}