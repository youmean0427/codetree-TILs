import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        String inp1 = sc.next();
        String inp2 = sc.next();
        String inp3 = sc.next();
        
        int res = 0;
        // i : 숫자1
        for (int i = 1; i <= 9; i++)
        {
            // j : 숫자2
            for (int j = 1; j <= 9; j++)
            {
                if (i != j)
                {
                    int ans = 0;
                    // 세로
                    for (int k = 0; k <= 2; k++)
                    {
                        // System.out.println(inp1.charAt(k));

                        int[] numCnt = new int[10];
                        if (inp1.charAt(k) == i + 48 || inp1.charAt(k) == j + 48)
                        {
                            numCnt[(int)inp1.charAt(k) - 48]++;
                            if (inp2.charAt(k)== i + 48 || inp2.charAt(k) == j + 48)
                            {
                                 numCnt[(int)inp2.charAt(k) - 48]++;
                                if (inp3.charAt(k)== i + 48 || inp3.charAt(k) == j + 48)
                                {
                                    numCnt[(int)inp3.charAt(k) - 48]++;
                                    if (numCnt[i] > 0 && numCnt[j] > 0)
                                    {
                                        ans++;
                                    }
                                }
                            }

                        }                        
                    }
                    
                    // 가로
                    int[] numCnt = new int[10];
                    if (inp1.charAt(0) == i + 48 || inp1.charAt(0) == j + 48)
                    {
                        numCnt[(int)inp1.charAt(0) - 48]++;
                        if (inp1.charAt(1) == i + 48 || inp1.charAt(1) == j + 48)
                        {
                            numCnt[(int)inp1.charAt(1) - 48]++;
                            if (inp1.charAt(2) == i + 48 || inp1.charAt(2) == j + 48)
                            {
                                numCnt[(int)inp1.charAt(2) - 48]++;
                                if (numCnt[i] > 0 && numCnt[j] > 0)
                                {
                                    ans++;
                                }
                            }
                        }
                    }

                    numCnt = new int[10];
                    if (inp2.charAt(0) == i + 48 || inp2.charAt(0) == j + 48)
                    {
                        numCnt[(int)inp2.charAt(0) - 48]++;
                        if (inp2.charAt(1) == i + 48 || inp2.charAt(1) == j + 48)
                        {
                            numCnt[(int)inp2.charAt(1) - 48]++;
                            if (inp2.charAt(2) == i + 48 || inp2.charAt(2) == j + 48)
                            {
                                numCnt[(int)inp2.charAt(2) - 48]++;
                                if (numCnt[i] > 0 && numCnt[j] > 0)
                                {
                                    ans++;
                                }
                            }
                        }
                    }

                    numCnt = new int[10];
                    if (inp3.charAt(0) == i + 48 || inp3.charAt(0) == j + 48)
                    {
                        numCnt[(int)inp3.charAt(0) - 48]++;
                        if (inp3.charAt(1) == i + 48 || inp3.charAt(1) == j + 48)
                        {
                            numCnt[(int)inp3.charAt(1) - 48]++;
                            if (inp3.charAt(2) == i + 48 || inp3.charAt(2) == j + 48)
                            {
                                numCnt[(int)inp3.charAt(2) - 48]++;
                                if (numCnt[i] > 0 && numCnt[j] > 0)
                                {
                                    ans++;
                                }
                            }
                        }
                    }

                    // \ 대각선
                    numCnt = new int[10];
                    if (inp1.charAt(0) == i + 48 || inp1.charAt(0) == j + 48)
                    {
                        numCnt[(int)inp1.charAt(0) - 48]++;
                        if (inp2.charAt(1) == i + 48 || inp2.charAt(1) == j + 48)
                        {
                            numCnt[(int)inp2.charAt(1) - 48]++;
                            if (inp3.charAt(2) == i + 48 || inp3.charAt(2) == j + 48)
                            {
                                numCnt[(int)inp3.charAt(2) - 48]++;
                                if (numCnt[i] > 0 && numCnt[j] > 0)
                                {
                                    ans++;
                                }
                            }
                        }
                    }
                    // / 대각선
                    numCnt = new int[10];
                    if (inp3.charAt(0) == i + 48 || inp3.charAt(0) == j + 48)
                    {
                        numCnt[(int)inp3.charAt(0) - 48]++;
                        if (inp2.charAt(1) == i + 48 || inp2.charAt(1) == j + 48)
                        {
                            numCnt[(int)inp2.charAt(1) - 48]++;
                            if (inp1.charAt(2) == i + 48 || inp1.charAt(2) == j + 48)
                            {
                                numCnt[(int)inp1.charAt(2) - 48]++;
                                if (numCnt[i] > 0 && numCnt[j] > 0)
                                {
                                    ans++;
                                }
                            }
                        }
                    }

                    // System.out.println(i + " " + j + " " + ans);
                    res += ans;


                }
            
            }
        }
        System.out.print(res / 2);
    }
}