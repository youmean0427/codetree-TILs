import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static int n, m, ans;
    public static ArrayList<Integer>[] arr;
    public static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new int[n+1];

        // ArrayList 형식을 가진 List 생성
        arr = new ArrayList[n+1];
        // ArrayList 객체를 원소로 생성
        for (int i = 0; i < n+1; i++)
        {
            arr[i] = new ArrayList<>();
        }


        for ( int i = 0; i < m; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            arr[x].add(y);
            arr[y].add(x);
        }
        
        dfs(1);
        System.out.print(ans);
    }

    public static void dfs(int idx)
    {
        visited[idx] = 1;

        for (int i = 0; i < arr[idx].size(); i++)
        {
            int g = arr[idx].get(i);
            
            if (visited[g] == 0)
            {
                ans++;
                dfs(g);
            }
        }        
    }
}