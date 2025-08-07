import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }

        double avg = sum / n;
        System.out.printf("%.1f\n", avg);

        String ans = "";
        if (avg >= 4.0)
            ans = "Perfect";
        else if (avg >= 3.0)
            ans = "Good";
        else
            ans = "Poor";
        System.out.print(ans);
    }
}