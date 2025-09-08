import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id2 = sc.next();
        int code2 = sc.nextInt();
       
        Product prod1 = new Product();
        Product prod2 = new Product(id2, code2);
        print(prod1);
        print(prod2);
        
    }

    public static void print(Product prod)
    {
        System.out.print("product " + prod.code + " is " + prod.name + "\n");
    }
}

class Product {

    String name;
    int code;

    public Product()
    {
        this.name = "codetree";
        this.code = 50;
    }


    public Product(String name, int code)
    {
        this.name = name;
        this.code = code;
    }

}