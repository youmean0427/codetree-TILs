public class Main {
    public static void main(String[] args) {
        for (int  i = 0; i < 5; i++) {
            print10Stars();
        }
    }

    public static void print10Stars() {
        
        for (int i = 1; i <= 10; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}