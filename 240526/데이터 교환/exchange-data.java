public class Main {
    public static void main(String[] args) {
        int a = 5, b = 6, c = 7;
        int tempA = a;
        int tempB = b;
        int tempC = c;

        b = tempA;
        c = tempB;
        a = tempC;

        System.out.print(a + "\n" + b + "\n" + c);
        
    }
}