package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class FruitsCovariance {
    static class Fruit {
        int weight;
    }

    static class Citrus extends Fruit {
        int weight;
    }

    static class Orange extends Citrus {

    }

    private static int totalWeight(ArrayList<? extends Citrus> oranges) {
        int weight = 0;
        for (Citrus orange : oranges) {
            weight += orange.weight;
        }
        // Возможно
        Fruit fruit = oranges.get(0);
//        oranges.add(new Orange());
        return weight;
    }

    public static void main(String[] args) {
        ArrayList<FruitsCovariance.Orange> oranges = new ArrayList<>();
        Orange o = new Orange();
        o.weight = 1;
        oranges.add(o);

        int w = totalWeight(oranges);
        System.out.println(w);
    }
}

