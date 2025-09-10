import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Score[] score = new Score[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            score[i] = new Score(name, score1, score2, score3);
        }
        
        Arrays.sort(score);

        for (int i = 0; i < n; i++)
        {
            System.out.println(score[i].name + " " + score[i].sc1 + " " + score[i].sc2 + " " + score[i].sc3);
        }
    }
}

class Score implements Comparable<Score> {
    String name;
    int sc1;
    int sc2;
    int sc3;

    public Score(String name, int sc1, int sc2, int sc3)
    {
        this.name = name;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;   
    }

    @Override
    public int compareTo(Score score)
    {
        return ((this.sc1 + this.sc2 + this.sc3) - (score.sc1 + score.sc2 + score.sc3));
    }

}