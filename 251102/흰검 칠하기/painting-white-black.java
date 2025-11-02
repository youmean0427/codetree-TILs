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

            if (d == 'R')
            {
                len += x;   
            }
            else if (d == 'L')
            {
                len += Math.abs(len - x);
            }

            xArr[i] = x;
            dArr[i] = d;
        }
  
        char[] dLine = new char[len];
        int[] wLine = new int[len];
        int[] bLine = new int[len]; 


        int start = len / 2;
        for (int i = 0; i < N; i++)
        {
            if (dArr[i] == 'R') {
                for (int j = start; j <= start + xArr[i] - 1; j++)
                {
                    dLine[j] = 'B';
                    bLine[j] += 1;
                }
                start = start + xArr[i] - 1;
            }
            else if (dArr[i] == 'L') {
                for (int j = start - xArr[i] + 1; j <= start; j++)
                {
                    dLine[j] = 'W';
                    wLine[j] += 1;
                }
                start = start - xArr[i] + 1;
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for (int k = 0; k < len; k++) {
            
            if (wLine[k] >= 2 && bLine[k] >= 2)
            {
                gray += 1;
                dLine[k] = 'G';
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