import java.util.*;

public class Main {
    public static int k;
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
       
       Scanner sc = new Scanner(System.in);
       k = sc.nextInt();
       n = sc.nextInt();
       back(1);

    }

    public static void back(int cnt)
    {

        if (cnt > n)
        {
            for (int j = 0; j < list.size(); j++)
            {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= k; i++)
        {
                if (cnt >= 3 && i == list.get(list.size()-2) &&  list.get(list.size()-1) ==  list.get(list.size()-2))
                {
                    continue;
                }
                else 
                {
                    list.add(i);
                    back(cnt+1);
                    list.remove(list.size()-1);
                }
        }

    }
}