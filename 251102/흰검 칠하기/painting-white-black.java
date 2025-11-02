import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] xArr = new int[N];
        char[] dArr = new char[N];
        
        int len = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            len += x;
            xArr[i] = x;
            dArr[i] = d;
        }

        int[] xLine = new int[len * 2];
        char[] dLine = new char[len * 2];

        int start = len;
        for (int i = 0; i < N; i++)
        {
            if (dArr[i] == 'R') {
                for (int j = start; j <= start + xArr[i] - 1; j++)
                {
                    xLine[j] += 1;
                    dLine[j] = 'B';
                }
                start = start + xArr[i] - 1;
            }
            else {
                for (int j = start - xArr[i] + 1; j <= start; j++)
                {
                    xLine[j] += 1;
                    dLine[j] = 'W';
                }
                start = start - xArr[i] + 1;
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for (int k = 0; k < len * 2; k++) {
            
            if (xLine[k] >= 4)
            {
                gray += 1;
                dLine[k] = 'N';
            }
            else if (dLine[k] == 'W')
            {
                white += 1;
            }
            else if (dLine[k] == 'B')
            {
                black += 1;
            }
        }

        System.out.print(white + " " + black + " " + gray);
    }
}