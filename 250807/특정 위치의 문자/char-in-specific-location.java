import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arr = new char[]{'L', 'E', 'B', 'R', 'O', 'S'};
        int flag = 0;
        char c = sc.next().charAt(0);

        for (int i = 0; i < 6; i++)
        {
            if (arr[i] == c)
            {
                System.out.print(i);
                flag = 1;
                break;
            }
        }
        if (flag==0)
        {
            System.out.print("None");
        }

    }
}