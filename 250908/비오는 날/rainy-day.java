import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        C[] c = new C[n];
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            
            c[i] = new C(date, day, weather);
        }

        C ans = new C(c[0].date, c[0].day, c[0].weather);


        for (int i = 0; i < n; i++)
        {
            if (ans.weather.equals("Rain") == false && c[i].weather.equals("Rain") == true)
            {
                ans.date = c[i].date;
                ans.day = c[i].day;
                ans.weather = c[i].weather;   
            }
            else if (c[i].date.split("-")[0].compareTo(ans.date) < 0 && c[i].weather == "Rain")
            {
                ans.date = c[i].date;
                ans.day = c[i].day;
                ans.weather = c[i].weather;
            }
        }

        System.out.print(ans.date + " " + ans.day + " " + ans.weather);
    }
}

class C {
    String date;
    String day;
    String weather;

    public C (String date, String day, String weather)
    {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }

}