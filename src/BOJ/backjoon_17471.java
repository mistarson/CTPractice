package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjoon_17471 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] population;
    static int N;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        population = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int areaCnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < areaCnt; j++) {
                int to = Integer.parseInt(st.nextToken());
                graph.get(i).add(to);
            }
        }

        boolean[] isVisited = new boolean[N + 1];
        isVisited[1] = true;
        getMinPopulationDiff(1, population[1], isVisited);

        if (minDiff == Integer.MAX_VALUE) {
            minDiff = -1;
        }
        System.out.println(minDiff);

    }

    static void getMinPopulationDiff(int currentCity, int populationSum, boolean[] isVisited) {

        // 가능한 방법인지, 그렇다면 minDiff 수정
        int anotherCitySum
                = ifPossibleGraphThenGetDiff(population, isVisited);
        if (anotherCitySum != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, Math.abs(anotherCitySum - populationSum));
        }

        for (int i = currentCity; i <= N; i++) {
            if (currentCity != i && !isVisited[i]) {
                isVisited[i] = true;
                getMinPopulationDiff(i, populationSum + population[i], isVisited);
                isVisited[i] = false;
            }
        }
    }

    static int ifPossibleGraphThenGetDiff(int[] population, boolean[] isVisited) {

        boolean[] copyIsVisited = new boolean[N + 1];

        // 1번 구역도 검사, 2번 구역도 검사해야함
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (cnt == 2) {
                break;
            }
            if (!copyIsVisited[i]) {
                cnt++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                copyIsVisited[i] = true;
                while (!queue.isEmpty()) {
                    Integer currentCity = queue.poll();
                    if (!isVisited[currentCity]) {
                        sum += population[currentCity];
                    }

                    List<Integer> nearCityList = graph.get(currentCity);
                    for (int j = 0; j < nearCityList.size(); j++) {
                        Integer nearCity = nearCityList.get(j);
                        if (!copyIsVisited[nearCity] && isVisited[i] == isVisited[nearCity]) {
                            copyIsVisited[nearCity] = true;
                            queue.add(nearCity);
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!copyIsVisited[i]) {
                sum = Integer.MAX_VALUE;
                break;
            }
        }

        return sum;

    }

}
