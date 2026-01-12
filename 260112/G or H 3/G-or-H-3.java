import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] chArr = new char[10001];
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            chArr[pos] = c;
        }
        
        int ans = 0;
        for (int i = 0; i < 10001-k; i++)
        {
            int sum = 0;
            for (int j = i; j <= i+k; j++)
            {
                if (chArr[j] == 'G')
                    sum++;
                if (chArr[j] == 'H')
                    sum+=2; 
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }
}