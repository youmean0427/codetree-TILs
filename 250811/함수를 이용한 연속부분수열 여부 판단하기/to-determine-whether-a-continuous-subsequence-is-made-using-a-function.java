import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        
        if (func(n1, n2, a, b) == 1)
            System.out.print("Yes");
        else
            System.out.print("No");
    }


    public static int func(int n1, int n2, int[] a, int[] b){
        
        int i = 0;
        int j = 0;

        while (i < n1)
        {
            if (j == n2)
                return 1;
            if (a[i] == b[j])
            {
                i++;
                j++;
            }
            else 
            {
                i++;
                if (j > 0)
                    j--;
                else
                    j = 0;
            }
        }
        if (j == n2)
            return 1;
        return 0;
    }
}