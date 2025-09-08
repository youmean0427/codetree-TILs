import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uCode = sc.next();
        char lColor = sc.next().charAt(0);
        int time = sc.nextInt();
        
        Bomb b = new Bomb(uCode, lColor, time);

        System.out.print("code : " + b.code + "\n");
        System.out.print("color : " + b.color + "\n");
        System.out.print("second : " + b.second);
    }
}

class Bomb {
    String code;
    char color;
    int second;

    public Bomb(String c, char l, int s)
    {
        this.code = c;
        this.color = l;
        this.second = s;
    }
}