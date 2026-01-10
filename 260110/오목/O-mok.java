import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        for (int i = 0; i < 19; i++)
        {
            for (int j = 0; j < 15; j++)
            { 
                if (arr[i][j] != 0 && arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i][j+2] && arr[i][j] == arr[i][j+3] && arr[i][j] == arr[i][j+4])
                {
                    System.out.println(arr[i][j]);
                    System.out.print((i+1) + " " + (j+3));      
                    return;      
                }
            }
        }

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 19; j++)
            {
                if (arr[i][j] != 0 && arr[i][j] == arr[i+1][j] && arr[i][j] == arr[i+2][j] && arr[i][j] == arr[i+3][j] && arr[i+4][j] == arr[i][j])
                {
                    System.out.println(arr[i][j]);
                    System.out.print((i + 3) + " " + (j+1));  
                    return;              
                }
            }
        }

        for (int i = 4; i < 19; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                if (arr[i][j] != 0 && arr[i][j] == arr[i-1][j+1] && arr[i][j] == arr[i-2][j+2] && arr[i][j] == arr[i-3][j+3] && arr[i][j] == arr[i-4][j+4])
                {
                    System.out.println(arr[i][j]);
                    System.out.print((i - 1) + " " + (j + 3));   
                    return;  
                }
            }
        }
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 15; j++)
            {
                 if (arr[i][j] != 0 && arr[i][j] == arr[i+1][j+1] && arr[i][j] == arr[i+2][j+2] && arr[i][j] == arr[i+3][j+3] && arr[i][j] == arr[i+4][j+4])
                {
                    System.out.println(arr[i][j]);
                    System.out.print((i + 3) + " " + (j + 3));  
                    return; 
                }
            }
        }
        
        System.out.print(0);
    }
}