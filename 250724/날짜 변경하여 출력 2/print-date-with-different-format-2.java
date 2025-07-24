import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] arr = sc.next().split("-");
        
        System.out.print(arr[2]+"."+arr[0]+"."+arr[1]);
    }
}