import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int len = input.length();
        int ans = 0;
        for (int i = 0; i < len-3; i++ )
        {
            for (int j = i+1; j < len-2; j++)
            {
                for (int k = j+1; k < len-1; k++)
                {
                    for (int l = k+1; l < len; l++)
                    {
                        if (input.charAt(i) == '(' && input.charAt(j) == '(' && input.charAt(k) == ')' && input.charAt(l) == ')')
                        {
                            if (i + 1 == j && k + 1 == l)
                            {
                                ans++;
                            }       
                        }

                    }
                }
            }
        }
        System.out.print(ans);
    }
}