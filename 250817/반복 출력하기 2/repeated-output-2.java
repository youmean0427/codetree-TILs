import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        helloWorld(n);
    }

    public static void helloWorld(int n)
    {
        if (n==0)
            return;
        helloWorld(n-1);
        System.out.println("HelloWorld");
    }
}