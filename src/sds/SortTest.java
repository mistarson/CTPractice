package sds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(2, 2, 3);
        Item item3 = new Item(3, 1, 2);


        List<Item> list = new ArrayList<>();

        list.add(item1);
        list.add(item2);
        list.add(item3);

        Collections.sort(list);

        System.out.println("list = " + list);

        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.compare(o1.c, o2.c);
            }
        });

        System.out.println("list = " + list);

        Collections.sort(list, Comparator.comparingInt(Item::getB));

        System.out.println("list = " + list);

    }
}

class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Item{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    // 음수 : 아무것도 안함
    // 0 :  아무것도 안함
    // 양수: Swap(교체)
    @Override
    public int compareTo(Item o) {

        int comp1 = Integer.compare(a, o.a);
        if (comp1 == 0) {
            return Integer.compare(b, o.b);
        } else {
            return comp1;
        }
//        if (a < o.a) {
//            return 1;
//        } else if (a == o.a) {
//            return 0;
//        } else {
//            return -1;
//        }
    }
}
