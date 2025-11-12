import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int T_MAX = 1000001;
        int[][] a = new int[n][2];
        int[][] b = new int[m][2];
        Now[] timeTree = new Now[T_MAX];
        for (int i = 0; i < 1000001; i++) {
            timeTree[i] = new Now();
        }

        int atime = 1;
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();

            for (int j = 1; j <= a[i][1]; j++)
            {
                timeTree[atime].a = timeTree[atime-1].a + a[i][0];
                atime++;
            }
        }

        int btime = 1;
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();
            b[i][1] = sc.nextInt();
            for (int j = 1; j <= b[i][1]; j++)
            {
                timeTree[btime].b = timeTree[btime-1].b + b[i][0];
                btime++;
            }
        }

        int winner = timeTree[1].a - timeTree[1].b;
        int change = 1;

        for (int i = 1; i < Math.max(atime, btime); i++)
        {

            if (timeTree[i].a - timeTree[i].b < 0)
            {
                if (winner > 0 || winner == 0)
                {
                    winner = -1;
                    change++;
                }
            }
            else if (timeTree[i].a - timeTree[i].b > 0)
            {
                if (winner < 0 || winner == 0)
                {
                    winner = 1;
                    change++;
                }
            }
            else if (timeTree[i].a - timeTree[i].b == 0 && winner != 0 )
            {
                winner = 0;
                change++;
            }
        }
        

        System.out.print(change);


    }
}

class Now{
    int a;
    int b;

    public Now()
    {
        this.a = 0;
        this.b = 0;
    }

    public Now(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

}