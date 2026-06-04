import java.util.Scanner;


class Wind {
    int x;
    char d;
    
    Wind(int x, char d)
    {
        this.x = x-1;
        this.d = d;
    }

}

public class Main {
    public static int n, m, q;
    public static int[][] board;
    public static Wind[] winds;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        winds = new Wind[q];

        board = new int[n][m];
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < q; i++)
        {
            winds[i] = new Wind(sc.nextInt(), sc.next().charAt(0));
        }

        for (int i = 0; i < q; i++)
        {
            move(winds[i].x, winds[i].d);
            spread(winds[i].x, winds[i].d, 1);
            spread(winds[i].x, winds[i].d, -1);
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static void move(int idx, char dir)
    {
        if (dir == 'L')
        {   
            int temp = board[idx][m-1];
            for (int i = m-1; i > 0; i--)
            {
                board[idx][i] =  board[idx][i-1];
            }
            board[idx][0] = temp;
        }
        else if (dir == 'R')
        {
            int temp = board[idx][0];
            for (int i = 0; i < m-1; i++)
            {
                board[idx][i] = board[idx][i+1];
            }
            board[idx][m-1] = temp;
        }
    }

    public static boolean comp(int currIdx, int nextIdx)
    {

        int cnt = 0;
        for (int i = 0; i < m; i++)
        {
            if (board[currIdx][i] == board[nextIdx][i])
            {
                cnt++;
            }
        }
        if (cnt > 0)
            return true;
        return false;
    }

    public static void spread(int currIdx, char dir, int num)
    {
        int nextIdx = currIdx + num;
        if (nextIdx >= n || nextIdx < 0)
        {
            return;
        }
        
        if (dir == 'R')
            dir = 'L';
        else if (dir == 'L')
            dir = 'R';

        if (comp(currIdx, nextIdx) == true)
        {
            move(nextIdx, dir);
            spread(nextIdx, dir, num);
        }
    }
}