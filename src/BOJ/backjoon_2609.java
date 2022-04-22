package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class backjoon_2609{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int gcd = gcd(A, B);
        int lcm = gcd * (A/gcd) * (B/gcd);
        
        System.out.println(gcd(A, B));
        System.out.println(lcm);
    }
    
    static int gcd(int n, int m) {
        if (n < m) {
            return gcd(m, n);
        }
        if (m != 0) {
            return gcd(m, n % m);
        }
        return n;
    }
}