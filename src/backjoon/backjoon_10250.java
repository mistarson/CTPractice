package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_10250 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];

            int floor = 0;
            int hosu = 0;

            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if (arr[2] < arr[0]) {
                floor = arr[2];
                hosu = 1;

            } else {
                if (arr[2] % arr[0] == 0) {
                    floor = arr[0];
                    hosu = arr[2] / arr[0];
                } else {
                    floor = arr[2] % arr[0];
                    hosu = arr[2] / arr[0] + 1;
                }
            }
            if (hosu < 10) {
                bw.write(String.valueOf(floor) + "0" + String.valueOf(hosu));
            } else {
                bw.write(String.valueOf(floor) + String.valueOf(hosu));
            }
            bw.newLine();
        }
        bw.flush();


    }
}
