import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] korean = new int[n];
        int[] english = new int[n];
        int[] math = new int[n];

        Score[] score = new Score[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            korean[i] = sc.nextInt();
            english[i] = sc.nextInt();
            math[i] = sc.nextInt();

            score[i] = new Score(names[i], korean[i], english[i], math[i]);
        }

        Arrays.sort(score);
        for (int i = 0; i < n; i++)
        {
            System.out.println(score[i].name + " " + score[i].kor + " " + score[i].eng + " " + score[i].math);
        }
        

    }
}

class Score implements Comparable<Score> {
    String name;
    int kor, eng, math;


    public Score(String name, int kor, int eng, int math)
    {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Score score)
    {
        if (this.kor == score.kor)
        {
            if (this.eng == score.eng)
            {
                return  score.math - this.math;
            }
            return score.eng - this.eng;
        }
        return score.kor - this.kor;
    }


}