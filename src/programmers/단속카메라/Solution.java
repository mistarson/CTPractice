package programmers.단속카메라;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[][] routes) {

        List<Route> list = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            list.add(new Route(routes[i][0], routes[i][1]));
        }

        Collections.sort(list);

        int min = list.get(0).end;
        int camera = 1;
        for (int i = 1; i < list.size(); i++) {
            Route route = list.get(i);
            if (route.start > min) {
                min = route.end;
                camera++;
            }
        }


        return camera;
    }

    static class Route implements Comparable<Route> {
        int start;
        int end;

        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {
            return Integer.compare(end, o.end);
        }
    }
}
