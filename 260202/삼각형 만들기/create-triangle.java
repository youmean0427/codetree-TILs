import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        double ans = 0;

        for (int i = 0; i < n - 2; i++)
        {   
      
            for (int j = i+1; j < n - 1; j++)
            {
                int xMatch = 0;
                int yMatch = 0;
                if (x[i] == x[j])
                {
                    xMatch = 1;
                }
                else if (y[i] == y[j])
                {
                    yMatch = 1;
                }

                for (int l = j+1; l < n; l++)
                {

                    if (xMatch == 1)
                    {
                        if (y[l] == y[i])
                        {
                            ans = Math.max(ans, Math.abs(y[i] - y[j]) * Math.abs(x[l] - x[i]) / 2.0);  
                        }
                        else if (y[l] == y[j])
                        {
                            ans = Math.max(ans, Math.abs(y[i] - y[j]) * Math.abs(x[l] - x[j]) / 2.0);  
                        }
                    }    
                    else if (yMatch == 1)
                    {
                        if (x[l] == x[i])
                        {
                            ans = Math.max(ans, Math.abs(x[i] - x[j]) * Math.abs(y[l] - y[i]) / 2.0); 
                        }
                        else if (x[l] == x[j])
                        {
                            ans = Math.max(ans, Math.abs(x[i] - x[j]) * Math.abs(y[l] - y[j]) / 2.0);  
                        }
                    }
                    else if (xMatch == 0 || yMatch == 0)
                    {
                        if (x[l] == x[i] && y[l] ==y[j])
                        {
                             ans = Math.max(ans, Math.abs(y[i] - y[l]) * Math.abs(x[l] - x[j]) / 2.0);  
                        }
                        else if (x[l] == x[j] && y[l] == y[i])
                        {
                            ans = Math.max(ans, Math.abs(y[j] - y[l]) * Math.abs(x[l] - x[i]) / 2.0);  
                        }


                    }
                }
            }
        }

        System.out.println((int)(ans * 2));
    
    }
}