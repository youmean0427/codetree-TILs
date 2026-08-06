import java.util.*;

class Input
{
    int a;
    int b;
    int c;

    Input(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    public static int n, m, max, ans;
    public static int[][] arr;
    public static Input[] input;
    public static int[] full;
    public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       m = sc.nextInt();
       
       input = new Input[m];
       full = new int[n+1];
       ans = m;
       for (int i = 0; i < m; i++)
       {
            int a = sc.nextInt();
            int b = sc.nextInt();

            max = Math.max(a, max);
            max = Math.max(b, max);

            input[i] = new Input(a, a+1, b);
       }

        back(0, 0);
        System.out.print(ans);

    }
    
    public static List<Input> list = new ArrayList<>();
    public static void back(int cnt, int idx)
    {
        if (cnt >= m)
        {
            move(list);
            return;
        }
        
        list.add(new Input(input[idx].a, input[idx].b, input[idx].c));
        back(cnt+1, idx+1);
        list.remove(list.size() - 1);
        back(cnt+1, idx+1);
        
    }

    public static void move(List<Input> chList)
    {
        int[] result = new int[n+1];
        chList.sort((cha, chb) -> cha.c - chb.c );

        for (int num = 1; num <= n; num++)
        {
            int now = num;
            for (int i = 0; i < chList.size(); i++)
            {
                int s = chList.get(i).a;
                int e = chList.get(i).b;
                
                if (s == now)
                {
                    now = e;
                }
                else if (e == now)
                {
                    now = s;
                }
            }
            result[num] = now;
            if (chList.size() == m)
            {
                    full[num] = now;
            }
        }

        int flag = 1;
        for (int ii = 0; ii <= n; ii++)
        {
            if (result[ii] != full[ii])
            {
                flag = 0;
                break;
            }
        }

        if (flag == 1)
        {
            ans = Math.min(ans, chList.size());
        }

    }
}