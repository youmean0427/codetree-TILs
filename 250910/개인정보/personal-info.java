import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        String[] names = new String[n];
        int[] heights = new int[n];
        double[] weights = new double[n];
        Info[] info = new Info[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            heights[i] = sc.nextInt();
            weights[i] = sc.nextDouble();

            info[i] = new Info(names[i], heights[i], weights[i]);
        }
        

        Arrays.sort(info);
        System.out.println("name");
        for (int i = 0; i < n; i++)
        {
            System.out.println(info[i].name + " " + info[i].h + " " + info[i].w);
        }
        Arrays.sort(info, (a, b) -> b.h - a.h);
        System.out.println();
        System.out.println("height");
        for (int i = 0; i < n; i++)
        {
            System.out.println(info[i].name + " " + info[i].h + " " + info[i].w);
        }

    }
}

class Info implements Comparable<Info> {
    String name;
    int h;
    double w;

    public Info(String name, int h, double w)
    {
        this.name  = name;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Info info)
    {
        return this.name.compareTo(info.name);
    }
}