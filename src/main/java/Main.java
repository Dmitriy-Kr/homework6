import Mymap.MyMap;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<>();

        System.out.println(myMap.put(3, "Ivanov"));
        System.out.println(myMap.put(8, "Petrov"));
        System.out.println(myMap.put(7, "Sidorov"));
        System.out.println(myMap.put(null, "Kylikovskiy"));
        System.out.println(myMap.put(12, "Ivanovskiy"));
        System.out.println(myMap.put(16, "Lebovskiy"));
        System.out.println(myMap.put(29, "Korh"));
        System.out.println(myMap.put(23, "Kupetman"));

        System.out.println("Size of map: " + myMap.getSize());
        System.out.println();

        System.out.println("myMap contains:");
        for (MyMap.Node<Integer, String> n : myMap.mapSat()) {
            System.out.println(n);
        }
        System.out.println();

        System.out.println(myMap.put(16, "Cook")); //append an item with an existing key
        System.out.println("Size of map: " + myMap.getSize());
        System.out.println();

        System.out.println("myMap contains:");
        for (MyMap.Node<Integer, String> n : myMap.mapSat()) {
            System.out.println(n);
        }
        System.out.println();

        Set<Integer> keys = myMap.keySet();
        System.out.println("Set of keys: " + keys);
        System.out.println();

        System.out.println("Method get:");
        System.out.println(null + " : " + myMap.get(null));
        for (int i = 0; i < 30; i++) {
            System.out.println(i + " : " + myMap.get(i));
        }
        System.out.println();

        System.out.println("Method containsKey:");
        for (int i = 0; i < 30; i++) {
            System.out.println("Contains key " + i + " : " + myMap.containsKey(i));
        }
        System.out.println("-------------------------------------------------------------------------------");
        MyMap<String, String> myMapS = new MyMap<>();

        System.out.println(myMapS.put("Petr", "Ivanov"));
        System.out.println(myMapS.put("Ivan", "Petrov"));
        System.out.println(myMapS.put("Nazar", "Sidorov"));
        System.out.println(myMapS.put(null, "Kylikovskiy"));
        System.out.println(myMapS.put("Nikolay", "Ivanovskiy"));
        System.out.println(myMapS.put("Igor", "Lebovskiy"));
        System.out.println(myMapS.put("Valentin", "Korh"));
        System.out.println(myMapS.put("Boris", "Kupetman"));

        System.out.println("Size of map: " + myMapS.getSize());
        System.out.println();

        System.out.println("myMap contains:");
        for (MyMap.Node<String, String> nS : myMapS.mapSat()) {
            System.out.println(nS);
        }
        System.out.println();

        System.out.println(myMapS.put("Nazar", "Cook"));//append an item with an existing key
        System.out.println("Size of map: " + myMapS.getSize());
        System.out.println();

        System.out.println("myMap contains:");
        for (MyMap.Node<String, String> nS : myMapS.mapSat()) {
            System.out.println(nS);
        }
        System.out.println();

        Set<String> keysS = myMapS.keySet();
        System.out.println("Set of keys: " + keysS);
        System.out.println();

        System.out.println("Method get:");
        for (String  k : myMapS.keySet()) {
            System.out.println(k + " = " + myMapS.get(k));
        }
        System.out.println("asdf = " + myMapS.get("asdf"));
        System.out.println();

        System.out.println("Method containsKey:");
        for (String  k : myMapS.keySet()) {
            System.out.println("Contains key " + k + " : " + myMapS.containsKey(k));
        }
        System.out.println("Contains key abcd : " + myMapS.containsKey("abcd"));
    }
}
