import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        System.out.println(map);

        map.put("A", 3);
        System.out.println(map);

    }

}
