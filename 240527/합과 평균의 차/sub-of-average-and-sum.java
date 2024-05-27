import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        System.out.println(a+b+c);
        System.out.println((a+b+c)/3);
        System.out.println((a+b+c) - (a+b+c)/3);
    }
}