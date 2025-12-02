package Concurrent;


import java.util.*;

public class Hashmap1 {

        public static void main(String[] args) {
            List<Integer> a = new ArrayList<>();
            a.add(4);
            a.add(1);
            a.add(6);
            a.add(9);
            a.add(10);
            int i = Collections.binarySearch(a, 9);
            System.out.println(i);
            System.out.println(a);
            LinkedHashMap<Integer,String > map = new LinkedHashMap<>();
            Collections.sort(a,(b,arr)->arr.compareTo(b));

            System.out.println(a);
            map.put(1,"A");
            map.put(3,"B");
            map.put(2,"C");
            map.put(4,"D");


        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer, String> mapElement = itr.next();
            System.out.println(mapElement);
        }


    }
}
