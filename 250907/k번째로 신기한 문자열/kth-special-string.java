import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        String[] checkedWords = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int m = 0;
        
        for (int i = 0; i < n; i++) {
            if (wordCheck(words[i], t) == 1)
            {
                checkedWords[m] = words[i];
                m++; 
            }
        }

        Arrays.sort(checkedWords, 0, m);
        System.out.print(checkedWords[k-1]);
        
    }

    public static int wordCheck(String word, String t)
    {
        for (int i = 0; i < t.length(); i++)
        {
            if (t.charAt(i) != word.charAt(i))
            {
                return 0;
            }
        }
        return 1;
    }
}