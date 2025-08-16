import java.util.Scanner;
public class Main {
    public static int ans = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        
        func(text, pattern);
        System.out.print(ans);
    }

    public static void func(String text, String pattern)
    {
            for (int i = 0; i <= text.length() - pattern.length(); i++)
            {
                int k = i;
                for (int j = 0; j <= pattern.length(); j++)
                {
                    if (j == pattern.length())
                    {
                        ans = k - pattern.length();
                        return;
                    }
                    if (text.charAt(k) == pattern.charAt(j))
                    {
                        k++;
                    }
                    else {
                        break;
                    }
                }
            }
            return;

    }
}