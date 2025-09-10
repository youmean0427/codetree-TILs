import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Info[] info = new Info[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            info[i] = new Info(name, height, weight);
        }

        Arrays.sort(info);

        for (int i = 0; i < n; i++)
        {
            System.out.println(info[i].name + " " + info[i].h + " " + info[i].w);
        }
    }
}

class Info implements Comparable<Info> {
    String name;
    int h, w;

    public Info(String name, int h, int w)
    {
        this.name = name;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Info info)
    {
        if (this.h == info.h)
        {
            return info.w - this.w;
        }
        return this.h - info.h;
    }
}