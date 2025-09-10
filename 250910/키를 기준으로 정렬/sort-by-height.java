import java.util.Scanner;
import java.util.Arrays;

class Info implements Comparable<Info> {
    String name;
    int h;
    int w;

    public Info(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this.w = w;
    }
    
    @Override
    public int compareTo(Info info){
        return this.h - info.h;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Info[] info = new Info[n];
        
        for (int i = 0; i < n; i++)
        {
            info[i] = new Info(sc.next(), sc.nextInt(), sc.nextInt()); 
        }
        Arrays.sort(info);

        for (int i = 0; i < n; i++)
        {
            System.out.println(info[i].name + " " + info[i].h + " " + info[i].w);
        }
    }
}
