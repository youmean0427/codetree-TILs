import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int[] arr = new int[26];

        for (int i = 0; i < A.length(); i++)
        {
            arr[((int)A.charAt(i)) - 97] += 1;   
        }
        if(check(arr) == 1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static int check(int[] arr)
    {
        int flag = 0;
        for (int i = 0; i < 26; i++)
        {
            if (flag == 2)
                return 1;
            else if (arr[i] >= 1)
                flag += 1;
        }
        return 0;
    }
}