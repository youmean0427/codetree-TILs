import java.util.*;

public class Main {
    public static List<Integer> list = new ArrayList<>();
    
    public static int n;
    public static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        back(1);
        System.out.print(sum);
    }

    public static void back(int cnt)
    {
        if (cnt > n)
        {
            sum += check();
            return;
        }
        for (int i = 1; i <= 4; i++)
        {
            list.add(i);
            back(cnt+1);
            list.remove(list.size()-1);
        }
    }

    public static int check()
    {
        int i = 0;
        while (i < n)
        {
            if (i + list.get(i) - 1 >= n)
            {
                return 0;
            }

            for (int j = i; j < i + list.get(i); j++)
            {
                if (list.get(i) != list.get(j))
                {
                    return 0;   
                }
            }
            i += list.get(i);
        }
        return 1;
    }
}