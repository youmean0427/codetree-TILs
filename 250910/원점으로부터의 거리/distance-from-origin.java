import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        Dot[] d = new Dot[n];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            int dis = Math.abs(points[i][0] - 0) + Math.abs(points[i][1] - 0);
            d[i] = new Dot(points[i][0], points[i][1], dis, i+1);
        }

        Arrays.sort(d, (a, b) -> a.d - b.d);

        for (int i = 0; i < n; i++)
        {
            System.out.println(d[i].n);
        }
      
    }
}

class Dot {
    int x;
    int y;
    int d;
    int n;

    public Dot(int x, int y, int d, int n)
    {
        this.x = x;
        this.y = y;
        this.d = d;
        this.n = n;
    }

    
}