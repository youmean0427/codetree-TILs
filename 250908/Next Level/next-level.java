import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        
        Info info1 = new Info();
        Info info2 = new Info(id, level);

        System.out.print("user " + info1.id + " lv " + info1.lv);
        System.out.println();
        System.out.print("user " + info2.id + " lv " + info2.lv);

    }
}

class Info {
    String id = "codetree";
    int lv = 10; 

    public Info ()
    {
    }

    public Info (String s, int i)
    {
        this.id = s;
        this.lv = i;
    }
}