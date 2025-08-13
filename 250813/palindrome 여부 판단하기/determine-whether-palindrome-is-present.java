import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String p = func(input);
        String ans = "No";

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == p.charAt(i))
                ans = "Yes";
            else 
            { 
                ans = "No";
                break;
            }
        }
        System.out.print(ans);
    }

    public static String func(String s)
    {
        String ss = "";
        for (int i = s.length()-1; i >= 0; i-- )
        {
            ss += s.charAt(i);
        }
        return ss;
    }
}