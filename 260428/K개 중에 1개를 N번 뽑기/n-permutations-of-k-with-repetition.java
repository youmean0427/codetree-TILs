import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        choose(1, k, n);

    }
    public static void choose(int cnt, int k, int n)
    {
        
        if (cnt > n)
        {
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= k; i++)
        {
            list.add(i);
            choose(cnt+1, k, n);
            list.remove(list.size()-1);
        }
        
    }
}