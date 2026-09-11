import java.util.Scanner;
public class Main {

    static int n, ans, minJump;
    static int[] arr, visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        minJump = Integer.MAX_VALUE;
        ans = -1;
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       choose(0, 0);
       if (minJump != Integer.MAX_VALUE) {
            ans = minJump;
       }

       System.out.print(ans);
    }


    static void choose(int idx, int jump) {
        if (idx >= n-1)
        {
            minJump = Math.min(minJump, jump);
            return;
        }

                
        for (int i = idx; i <= idx + arr[idx]; i++)
        {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            choose(i, jump+1);
            visited[i] = 0;
        }
        

    }



}