public class Main {
    public static void main(String[] args) {
       
       int a = 3;
       int b = 5;
       int temp;

       temp = b;
       b = a;
       a = temp;

       System.out.print(a + "\n" + b);

    }
}