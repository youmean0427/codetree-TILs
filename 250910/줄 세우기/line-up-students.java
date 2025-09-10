import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] weight = new int[n];
        Info[] info = new Info[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            info[i] = new Info(height[i], weight[i], i+1);
        }
        
        Arrays.sort(info);

        for (int i = 0; i <n; i++)
        {
        System.out.println(info[i].h + " " + info[i].w + " " + info[i].n);
        }
    }
}

class Info implements Comparable<Info> {
    int h, w, n;

    public Info(int h, int w, int n)
    {
        this.h = h;
        this.w = w;
        this.n = n;
    }

    @Override
    public int compareTo(Info info)
    {
        if (this.h == info.h) 
        {
            if (this.w == info.w)
            {
                return this.n - info.n;
            }
            return info.w - this.w;
        }
        return info.h - this.h;
    }
}