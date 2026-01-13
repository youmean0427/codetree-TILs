import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[101];
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            arr[position] = ch;
        }

        int ans = 0;
        for (int i = 0; i < 101; i++)
        {
            int gg = 0;
            int hh = 0;
            for (int j = i; j < 101; j++)
            {
                if (arr[j] == 'G')
                    gg++;
                else if (arr[j] == 'H')
                    hh++;
                
                if ((gg == hh) || (gg > 0 && hh == 0) || (hh > 0 && gg == 0))
                {   
                    if (arr[j] == 'G' || arr[j] == 'H') 
                    {
                        if ((arr[i] == 'G' || arr[i] == 'H'))
                        {
                            ans = Math.max(ans , j - i);
                        }
                    }
                }
            }
        }
        System.out.print(ans);
    }
}