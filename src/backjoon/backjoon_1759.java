package backjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class backjoon_1759 {
    static int L, C;
    static char arr[],newarr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        newarr = new char[C];
        visited = new boolean[C];

        for(int i = 0; i< C; i++) {
            newarr[i] = sc.next().charAt(0);
        }

        Arrays.sort(newarr);

        combination(0, 0);

    }
    static void combination(int start,int cnt) {
        if(cnt== L) {

            int v = 0;
            int cc = 0;

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i< C; i++) {
                if(visited[i]) {
                    sb.append(newarr[i]);

                    if(newarr[i]=='a'||newarr[i]=='e'||newarr[i]=='i'||newarr[i]=='o'||newarr[i]=='u') {
                        v++;
                    }else {
                        cc++;
                    }
                }
            }
            if(v>=1 && cc>=2) System.out.println(sb);

        }

        for(int i = start; i< C; i++) {
            visited[i]=true;
            combination(i+1,cnt+1);
            visited[i]=false;
        }
    }
}
