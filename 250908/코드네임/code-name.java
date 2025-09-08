import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Code[] code = new Code[5];
        int ansScore = Integer.MAX_VALUE;
        char ansChar = 'A';

        for (int i = 0; i < 5; i++)
        {
            
            code[i] = new Code(sc.next().charAt(0), sc.nextInt());
            if (ansScore > code[i].score)
            {
                ansScore = code[i].score;
                ansChar = code[i].name;
            }
        }

        System.out.print(ansChar + " " + ansScore);
    }
}

class Code {
    char name;
    int score;

    public Code(char name, int score)
    {
        this.name = name;
        this.score = score;
    }

}