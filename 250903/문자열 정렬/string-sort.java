import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String ss = new String(chars);
        System.out.print(ss);

    }
}