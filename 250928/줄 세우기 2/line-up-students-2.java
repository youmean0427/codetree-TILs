import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Info[] info = new Info[n];
        
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            int weight = sc.nextInt();
            info[i] = new Info(height, weight,i+1);
        }


        Arrays.sort(info);
        for (int i = 0; i < n; i++)
        {
            System.out.print(info[i].h + " " + info[i].w + " " + info[i].n);
            System.out.println();
        }



    }
}

class Info implements Comparable<Info> {
    int h;
    int w;
    int n;

    public Info(int height, int weight, int num)
    {
        this.h = height;
        this.w = weight;
        this.n = num;
    }

    public int compareTo(Info info) {
        if (this.h == info.h)
        {
            return info.w - this.w;
        }
        return this.h - info.h;
    }

}