import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 1000;
        int[] arr = new int[2001];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'R') {
                for (int j = ans; j <= ans + x - 1; j++)
                {
                    arr[j] += 1;
                }
                ans += x;
            }
            else if (dir == 'L') {
                for (int j = ans - x; j <= ans - 1; j++)
                {
                    arr[j] += 1;
                }
                ans -= x;
            }
        
        }

    
        int cnt = 0;
        for (int k = 0; k <= 2000; k++) {
            if (arr[k] >= 2){
                cnt += 1;
            }
        }
        System.out.print(cnt);

    }
}