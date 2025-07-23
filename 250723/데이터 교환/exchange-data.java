public class Main {
    public static void main(String[] args) {
        
        int a = 5, b = 6, c = 7;
        int temp, temp2;

        temp = b;
        b = a;
        temp2 = c;
        c = temp;
        a = temp2;

        System.out.print(a + "\n" + b + "\n" + c);

    }
}