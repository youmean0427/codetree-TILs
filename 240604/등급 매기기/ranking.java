import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String score = "F";
        if (n >= 90) {
            score = "A";
        } else if (n >= 80) {
            score = "B";
        } else if (n >= 70) {
            score = "C";
        } else if (n >= 60) {
            score = "D";
        }

        System.out.println(score);
    }
}