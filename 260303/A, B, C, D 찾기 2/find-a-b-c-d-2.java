import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[15];

        int maxNum = 0;
        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
            maxNum = Math.max(maxNum, arr[i]);
        }
        
        Arrays.sort(arr);
        for (int a = 1; a < maxNum; a++)
        {
            for (int b = a; b < maxNum; b++)
            {
                for (int c = b; c < maxNum; c++)
                {
                    for (int d = c; d < maxNum; d++)
                    {

                        int[] visited = new int[15]; 
                        visited[0] = a;
                        visited[1] = b;
                        visited[2] = c;
                        visited[3] = d;
                        visited[4] = a+b;
                        visited[5] = b+c;
                        visited[6] = c+d;
                        visited[7] = d+a;
                        visited[8] = a+c;
                        visited[9] = b+d;
                        visited[10] = a+b+c;
                        visited[11] = a+b+d;
                        visited[12] = a+c+d;
                        visited[13] = b+c+d;
                        visited[14] = a+b+c+d;

                        Arrays.sort(visited);

                        int cnt = 0;
                        for (int i = 0; i < 15; i++)
                        {
                            if (arr[i] == visited[i])
                            {
                                cnt++;
                            }
                            else
                            {
                                break;
                            }
                        }
                        if (cnt == 15)
                        {
                            System.out.print(a + " " + b + " " + c + " " + d);
                            return;
                        }
                    }
                }
            }
        }
    }
}