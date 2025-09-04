import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        
        char[] arr1 = new char[word1.length()];
        char[] arr2 = new char[word2.length()];

        toArr(arr1, word1);
        toArr(arr2, word2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        String ans = "Yes";

        if (word1.length() != word2.length())
        {
            ans = "No";
        }
        else 
        {
            for (int i = 0; i < word1.length(); i++)
            {
                if (arr1[i] != arr2[i])
                {
                    ans = "No";
                    break;
                }
            }
        }

        System.out.print(ans);
    }

    public static void toArr(char[] arr, String word)
    {
        for (int i = 0; i < word.length(); i++)
        {
            arr[i] = word.charAt(i);
        }
    }
}