import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요일맞추기 {

    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startMonth = Integer.parseInt(st.nextToken());
        int startDay = Integer.parseInt(st.nextToken());
        int endMonth = Integer.parseInt(st.nextToken());
        int endDay = Integer.parseInt(st.nextToken());

        int dayDiff = getTotalDays(endMonth, endDay) - getTotalDays(startMonth, startDay);
        if (dayDiff % 7 < 0) {
            System.out.println(days[dayDiff % 7 + 7]);
        } else {
            System.out.println(days[dayDiff % 7]);
        }
    }

    static int getTotalDays(int a, int b) {
        int totalDays = 0;
        for (int i = 1; i < a; i++) {
            totalDays += months[i];
        }

        totalDays += b;

        return totalDays;
    }

}
