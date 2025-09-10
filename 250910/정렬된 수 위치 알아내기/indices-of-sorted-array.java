import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Num[] nums = new Num[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            nums[i] = new Num(arr[i], i);
        }

        Arrays.sort(nums, (a, b) -> a.num - b.num);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
        {
            ans[nums[i].idx] = i+1;
        }

        for (int i = 0; i < n; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}


class Num {
    int num;
    int idx;

    public Num(int num, int idx)
    {
        this.num = num;
        this.idx = idx;
    }
}
