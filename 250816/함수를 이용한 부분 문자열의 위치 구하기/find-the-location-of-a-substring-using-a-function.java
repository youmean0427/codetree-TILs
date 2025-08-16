import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        
        int ans = func(text, pattern);
        System.out.print(ans);
    }

    public static int func(String text, String pattern)
    {
            int i = 0;
            int j = 0;

            while (i <= text.length())
            {
                if (j == pattern.length())
                    return i - pattern.length();
                if (i == text.length())
                    return -1;
                if (text.charAt(i) == pattern.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    i++;
                    j = 0;
                }
            }
            return -1;

    }
}