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
                int flag = 0;                
                for(int j = 0; j < pattern.length(); j++)
                {
                    if (text.charAt(i + j) != pattern.charAt(j))
                    {
                        flag = 0;
                        break;
                    }
                    else
                        flag = 1;
                }

                if (flag == 1)
                {
                    ans = i;
                    return;
                }
            }

    }
}