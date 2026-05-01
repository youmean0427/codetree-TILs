import java.util.*;
public class Main {
    public static List<Integer> list = new ArrayList<>();
    public static int[] visited;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new int[n+1];
        back(1);
    }


    public static void back(int cnt)
    {
        if (cnt > n)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.print(list.get(i) + " ");

            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++)
        {
            if (visited[i] == 1)
                continue;
            
            visited[i] = 1;
            list.add(i);
            back(cnt+1);
            list.remove(list.size()-1);
            visited[i] = 0;
        }

    }
}