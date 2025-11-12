import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        int T = sc.nextInt();
        int[] oneHand = new int[251];
        int[] twoHand = new int[251];
        // 감염 여부
        int[] infected = new int[N+1];
        // 감염 시키는 횟수
        int[] infectCnt = new int[N+1]; 
        
        infected[P] = 1;
        infectCnt[P] = K;
        
        int[][] shakes = new int[T][3];
        for (int i = 0; i < T; i++) {
            shakes[i][0] = sc.nextInt();
            shakes[i][1] = sc.nextInt();
            shakes[i][2] = sc.nextInt();
            
            // 시간을 인덱스로 개발자를 넣기 : 시간 순서로 Sort
            oneHand[shakes[i][0]] = shakes[i][1];
            twoHand[shakes[i][0]] = shakes[i][2];
        }

        int oneH = 0;
        int twoH = 0;
        for (int i = 0; i < 251; i++)
        {
            oneH = oneHand[i];
            twoH = twoHand[i];

            if(infected[oneH] == 1 &&  infected[twoH] == 1)
            {
                if(infectCnt[oneH] > 0)
                    infectCnt[oneH] -= 1;
                if(infectCnt[twoH] > 0)
                    infectCnt[twoH] -= 1;
            }

            else if(infected[oneH] == 1)
            {
                if(infectCnt[oneH] > 0)
                {
                    infectCnt[oneH] -= 1;
                    infected[twoH] = 1;
                    infectCnt[twoH] = K;
                }
            }
            else if(infected[twoH] == 1)
            {
                if(infectCnt[twoH] > 0)
                {
                    infectCnt[twoH] -= 1;
                    infected[oneH] = 1;
                    infectCnt[oneH] = K;
                }
            }
        }

        for (int i = 1; i < N+1; i++)
        {
            System.out.print(infected[i]);
        }

    }

  
}