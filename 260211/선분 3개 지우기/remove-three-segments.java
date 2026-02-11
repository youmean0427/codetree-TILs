import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int ans = 0;

        for (int i = 0; i < n-2; i++)
        {
            for (int j = i+1; j <n-1; j++)
            {
                for (int k = j+1; k < n; k++)
                {
                    int[] cnt = new int[101];
                    for (int l = 0; l < n; l++)
                    {
                        if (l != i && l != j && l != k)
                        {
                            for (int m = a[l]; m <= b[l]; m++)
                            {
                                cnt[m]++;
                            }
                        }
                    }

                    int flag = 0;
                    
                    for (int m = 0; m < 101; m++)
                    {
                        if (cnt[m] > 1)
                        {
                            flag = 1;
                            break;
                        }
                    }

                    if (flag == 0)
                    {
                        ans++;
                    }

                }
            }
        }
        System.out.print(ans);
        
    }
}