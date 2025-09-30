import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        int x = 0;
        int two  = 1;

        for (int i = binary.length()-1; i >= 0; i--)
        {   
            
            x += ((int)(binary.charAt(i)) - 48) * two;
            two *= 2;
        }

        x *= 17;
        
        int[] ans = new int[20];
        int j = 0;
        while (true)
        {
            if (x < 2)
            {
                ans[j] = x;
                break;
            }
            ans[j] = x % 2;
            x /= 2;
            j++;
        }
        for (int k = j; k >= 0; k--)
        {
            System.out.print(ans[k]);
        }

    }
}