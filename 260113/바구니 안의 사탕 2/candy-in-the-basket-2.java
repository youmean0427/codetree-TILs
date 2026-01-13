import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        int[] arr = new int[101 + 2 * k];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
            arr[positions[i] +  k] += candies[i];
        }
        int ans = 0;
        for (int i = k; i < 101; i++)
        {
            int sum = 0;
            for (int j = i - k ; j <= i+k; j++)
            {
                sum += arr[j];
            }
            ans = Math.max(ans, sum);
            
        }
        System.out.println(ans);   
    }
}
