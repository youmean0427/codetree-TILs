import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode;
        char mPoint;
        int time;
        
        sCode = sc.next();
        mPoint = sc.next().charAt(0);
        time = sc.nextInt();

        Secret s1 = new Secret(sCode, mPoint, time);

        System.out.print("secret code : " + s1.s + "\n");
        System.out.print("meeting point : " + s1.c + "\n");
        System.out.print("time : " + s1.i);
    }
}

class Secret {
    String s;
    char c;
    int i;

    public Secret(String code, char point, int time) {
        this.s = code;
        this.c = point;
        this.i = time;
    }
}