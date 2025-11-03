import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[200000];
        int start = 100000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d == 'R') {
                for (int j = start; j <= start + x - 1; j++) {
                    arr[j] = 2;
                    
                }
                start = start + x - 1;
            }
            else if (d == 'L') {
                for (int j = start - x + 1; j <= start; j++) {
                    arr[j] = 1;
                }
                start = start - x + 1;
            }
        }

        int black = 0;
        int white = 0;


        for (int i = 0; i < 200000; i++) {
            if (arr[i] == 2)
                black += 1;
            else if (arr[i] == 1)
                white += 1;
        }

        System.out.print(white + " " + black);
    }
}