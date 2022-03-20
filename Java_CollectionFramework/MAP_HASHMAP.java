package DATA_STRUCTURE.Java_CollectionFramework;

import java.util.Map;
import java.util.TreeMap;
// import java.util.HashMap; //Don't know but its giving error
//ERROR -> The import java.util.HashMap cannot be resolvedJava(268435846)

public class MAP_HASHMAP {
    public static void main(String[] args) {
        Map<Integer, String> m = new TreeMap<>();
        // TreeMap maintains element in increasing order of keys
        m.put(1, "one");
        m.put(5, "five");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");

        m.putIfAbsent(4, "FOUR");// This will put 4 if its not there in map

        System.out.println(m);
        System.out.println(m.containsKey(4));
        System.out.println(m.isEmpty());

        for (Map.Entry<Integer, String> e : m.entrySet()) {
            // this loop will print both value and key
            System.out.println(e);
        }
        for (Map.Entry<Integer, String> e : m.entrySet()) {
            // this loop will print only keys
            System.out.println(e.getKey());
        }
        for (Map.Entry<Integer, String> e : m.entrySet()) {
            // this loop will print only values
            System.out.println(e.getValue());
        }

        // we can also access individually like only key or value
        for (Integer value : m.keySet()) { // this can access only keys
            System.out.println(value);
        }
        for (String value : m.values()) { // this can access only values
            System.out.println(value);
        }
    }
}
