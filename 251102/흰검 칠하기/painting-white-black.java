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
                len += x;   
            else if (d == 'L')
                len += Math.abs(len - x);

            xArr[i] = x;
            dArr[i] = d;
        }
  
        Info[] ans = new Info[len];
        for (int i = 0; i < len; i++)
            ans[i] = new Info(0, 0, 'N');

        int start = len / 2;
        for (int i = 0; i < N; i++)
        {
            if (dArr[i] == 'R') {
                for (int j = start; j <= start + xArr[i] - 1; j++)
                {
                    ans[j].now = 'B';
                    ans[j].black += 1;
                }
                start = start + xArr[i] - 1;
            }
            else if (dArr[i] == 'L') {
                for (int j = start - xArr[i] + 1; j <= start; j++)
                {
                    ans[j].now = 'W';
                    ans[j].white += 1;
                }
                start = start - xArr[i] + 1;
            }
        }

        int white = 0;
        int black = 0;
        int gray = 0;

        for (int k = 0; k < len; k++) {
            
            if (ans[k].white >= 2 && ans[k].black >= 2)
                gray += 1;
            else if (ans[k].now == 'W')
                white += 1;
            else if (ans[k].now == 'B')
                black += 1;
        }
        System.out.print(white + " " + black + " " + gray);
    }

    static class Info {
        int black;
        int white;
        char now;

        public Info(int b, int w, char n)
        {
            this.black = b;
            this.white = w;
            this.now = n;
        } 
    }
}