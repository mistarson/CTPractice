package sds.p3955;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // X : 인당 나눠줄 사탕의 수
            // Y: 사탕 봉지의 수
            // A * x + 1 = B * y
            // Ax+ By = C 의 형태로 변환
            // -Ax + By = 1
            // A(-x) + By = 1 의 형태로 변환 (-x < 0)

            // 1. 해 검증
            // D = gcd(A, B) = egcd(A, B).r
            // Ax + By = C 일 때, C % D == 0 이어야 해를 가질 수 있음: 배주 항등식
            // C % D !=0 -> 해가 없다

            EGResult result = extendedGcd(A, B);

            if (result.r != 1) {
                System.out.println("IMPOSSIBLE");
            } else {

                // 2. 초기 해 구하기
                // x0 = s * C / D
                // y0 = t * C / D

                // 3. 일반 해 구하기
                // x = x0 + B / D * k
                // y = y0 - A / D * k
                long x0 = result.s;
                long y0 = result.t;

                // 4. k의 범위
                // x < 0
                // x0 + B * k < 0 (이 문제는 D가 1이니까 생략, D가 1이 아니면 달고 다녀야 함)
                // k < -x0 / B

                // 0 < y <= 1e9
                // 0 < y0 - A * k <= 1e9 (D는 1이니까 생략)
                // -y0 < -A * k <= 1e9 - y0
                // ( y0 - 1e9 ) / A <= k < y0 / A

                //                    k < -x0 / B
                //( y0 - 1e9 ) / A <= k < y0 / A
                //더블로 컨버팅하고 나누기
                // 경계값 k 찾기 ( 0.5라면 MATH.ceil(0.5) -1 하면 됨
                long kFromY = (long) Math.ceil((double) y0 / (double) A) - 1;
                long kFromX = (long) Math.ceil((double) -x0 / (double) B) - 1;
                long k = Math.min(kFromY, kFromX);
                long kLimitFromY = (long) Math.ceil((y0 - 1e9) / (double) A);
                // 5. 만족하는 k를 찾고 k를 통해 y를 구한다.
                if (kLimitFromY <= k) {
                    System.out.println(y0 - A * k);
                } else {
                    System.out.println("IMPOSSIBLE");
                }

            }

        }




    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;


            temp = r0 - q * r1; // 모듈러 연산으로 바꿔도 상관없음음
           r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }

}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "EGResult{" +
                "s=" + s +
                ", t=" + t +
                ", r=" + r +
                '}'+ "\n";
    }
}