import java.util.*;
public class Main {
    
    public static List<Character> list = new ArrayList<>();
    public static int[] alphaNum, alpha;
    public static int maxAns;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        alpha = new int[6];
        maxAns = Integer.MIN_VALUE;

        for (int i = 0; i < expression.length(); i++)
        {
            char x = expression.charAt(i);
            if (x == 'a')
                alpha[0] = 1;
            else if (x == 'b')
                alpha[1] = 1;
            else if (x == 'c')
                alpha[2] = 1;
            else if (x == 'd')
                alpha[3] = 1;
            else if (x == 'e')
                alpha[4] = 1;
            else if (x == 'f')
                alpha[5] = 1;               
            list.add(x);
        }

        int alphaCnt = 0;
        for (int i = 0; i < 6; i++)
        {
            if (alpha[i] == 1)
            {
                alphaCnt++;
            }
        }

        alphaNum = new int[6];
        dfs(0);
        System.out.print(maxAns);
    }

    public static void cal()
    {
        int ans = 0;

        char x = list.get(0);
        if (x == 'a')
            ans = alphaNum[0];
        else if (x == 'b')
            ans = alphaNum[1];
        else if (x == 'c')
            ans = alphaNum[2];
        else if (x == 'd')
            ans = alphaNum[3];
        else if (x == 'e')
            ans = alphaNum[4];
        else if (x == 'f')
            ans = alphaNum[5];      

        for (int i = 1; i < list.size(); i+=2)
        {
            if (list.get(i) == '-')
            {   
                if (list.get(i+1) == 'a')
                    ans = ans - alphaNum[0];
                else if (list.get(i+1) == 'b')
                    ans = ans - alphaNum[1];
                else if (list.get(i+1) == 'c')
                    ans = ans - alphaNum[2];
                else if (list.get(i+1) == 'd')
                    ans = ans - alphaNum[3];
                else if (list.get(i+1) == 'e')
                    ans = ans - alphaNum[4];
                else if (list.get(i+1) == 'f')
                    ans = ans - alphaNum[5];    
            }
            else if (list.get(i) == '+')
            {
                if (list.get(i+1) == 'a')
                    ans = ans + alphaNum[0];
                else if (list.get(i+1) == 'b')
                    ans = ans + alphaNum[1];
                else if (list.get(i+1) == 'c')
                    ans = ans + alphaNum[2];
                else if (list.get(i+1) == 'd')
                    ans = ans + alphaNum[3];
                else if (list.get(i+1) == 'e')
                    ans = ans + alphaNum[4];
                else if (list.get(i+1) == 'f')
                    ans = ans + alphaNum[5];
            }
            else if (list.get(i) == '*')
            {
                if (list.get(i+1) == 'a')
                    ans = ans * alphaNum[0];
                else if (list.get(i+1) == 'b')
                    ans = ans * alphaNum[1];
                else if (list.get(i+1) == 'c')
                    ans = ans * alphaNum[2];
                else if (list.get(i+1) == 'd')
                    ans = ans * alphaNum[3];
                else if (list.get(i+1) == 'e')
                    ans = ans * alphaNum[4];
                else if (list.get(i+1) == 'f')
                    ans = ans * alphaNum[5];
            }    
        }

        maxAns = Math.max(maxAns, ans);
    }


    public static void dfs(int idx)
    {
        if (idx >= 6)
        {
            cal();
            return;
        }

        for (int i = 1; i <= 4; i++)
        {
            if (alpha[idx] == 1)
            {
                alphaNum[idx] = i;
                dfs(idx+1);
                alphaNum[idx] = 0;
            }
            else
            {
                dfs(idx+1);
            }
        }
    }
}