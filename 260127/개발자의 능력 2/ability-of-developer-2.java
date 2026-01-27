import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ability1 = sc.nextInt();
        int ability2 = sc.nextInt();
        int ability3 = sc.nextInt();
        int ability4 = sc.nextInt();
        int ability5 = sc.nextInt();
        int ability6 = sc.nextInt();
        

        int[] arr = new int[6];
        arr[0] = ability1;
        arr[1] = ability2;
        arr[2] = ability3;
        arr[3] = ability4;
        arr[4] = ability5;
        arr[5] = ability6;

        Arrays.sort(arr);

        int x = arr[0] + arr[5];
        int y = arr[1] + arr[4];
        int z = arr[2] + arr[3];

        int[] sortArr = new int[3];
        sortArr[0] = x;
        sortArr[1] = y;
        sortArr[2] = z;

        Arrays.sort(sortArr);

        System.out.print(sortArr[2] - sortArr[0]);

    }
}