import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }
        int ans = 0;
        
        for (int i = 1; i <= 9; i++)
        {
            for (int j = 1; j <= 9; j++)
            {
                for (int k = 1; k <= 9; k++)
                {
                    int nCnt = 0;
                    if (i != j && j != k && i != k)
                    {
                        
                        for (int x = 0; x < n; x++)
                        {

                            int cnt1 = 0;
                            int cnt2 = 0;
                            int num_tmp = num[x];

                            if (k == (num_tmp % 10))
                            {
                                cnt1++;
                            }
                            else if ((num_tmp % 10) == i || (num_tmp % 10) == j)
                            { 
                                cnt2++;
                            }

                            num_tmp /= 10;
                            
                            if (j == (num_tmp % 10))
                            {
                                cnt1++;
                            }
                            else if ((num_tmp % 10) == i || (num_tmp % 10) == k)
                            {
                                cnt2++;
                            }

                            num_tmp /= 10;
                            
                            if (i == (num_tmp % 10))
                            {
                                cnt1++;
                            }
                            else if ((num_tmp % 10) == j || (num_tmp % 10) == k)
                            {
                                cnt2++;
                            }
                            
                            if (cnt1 == count1[x] && cnt2 == count2[x])
                            {
                                nCnt++;
                            }

                        }
                    }
                    if (nCnt == n)
                    {
                        ans++;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}