import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        
        int[] num = new int[5];
        num[0] = a;
        num[1] = b;
        num[2] = c;
        num[3] = d;
        num[4] = e;

        int[] visited = new int[5];
        int ans = 1000;

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (i != j)
                {
                    int part1 = num[i] + num[j];
                    visited[i] = 1;
                    visited[j] = 1;

                    for (int k = 0; k < 5; k++)
                    {
                        for (int l = 0; l < 5; l++)
                        {
                            if (visited[k] == 0 && visited[l] == 0)
                            {
                                if (k != l)
                                {
                                    int part2 = num[k] + num[l];
                                    
                                    if (part1 != part2) {
                                        visited[k] = 1;
                                        visited[l] = 1;

                                        for (int m = 0; m < 5; m++)
                                        {
                                            if (visited[m] == 0)
                                            {
                                                if (part1 != num[m] && part2 != num[m])
                                                {
                                                    int[] sortArr = new int[3];
                                                    sortArr[0] = part1;
                                                    sortArr[1] = part2;
                                                    sortArr[2] = num[m];

                                                    Arrays.sort(sortArr);
                                                    
                                                    ans = Math.min(ans, sortArr[2] - sortArr[0]);

                                                }
                                            }
                                        }
                                        
                                        visited[k] = 0;
                                        visited[l] = 0;
                                    }

                                    
                                }
                            }

                        }
                    }

                    visited[i] = 0;
                    visited[j] = 0;
                }
            }
        }
        if (ans == 1000)
        {
            ans = -1;
        }
        System.out.print(ans);
    }
}