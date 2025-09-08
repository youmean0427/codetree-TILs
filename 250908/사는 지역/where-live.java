import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        String[] addresses = new String[n];
        String[] regions = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            addresses[i] = sc.next();
            regions[i] = sc.next();
        }
        
        Place[] p = new Place[n];

        for (int i = 0; i < n; i++) {
            p[i] = new Place(names[i], addresses[i], regions[i]);
        }

        int start = 0;

        for (int i = 1; i < n; i++)
        {
            if (p[start].a.compareTo(p[i].a) < 0)
            {
                start = i;
            }
        }

        System.out.print("name " + p[start].a + "\n");
        System.out.print("addr " + p[start].b + "\n");
        System.out.print("city " + p[start].c);
        
    }
}

class Place {
    String a;
    String b;
    String c;

    public Place(String a, String b, String c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}