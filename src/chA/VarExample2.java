package chA;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VarExample2 {
    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("신용권", 85);
        map.put("이승철", 90);
        map.put("정승재", 95);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    public static void method2() {
        var map = new HashMap<String, Integer>();
        map.put("신용권", 85);
        map.put("이승철", 90);
        map.put("정승재", 95);

        // var entrySet = map.entrySet();
        // var entryIterator = entrySet.iterator();
        // while(entryIterator.hasNext()) {
        //     var entry = entryIterator.next();
        //     var key = entry.getKey();
        //     var value = entry.getValue();
        //     System.out.println(key + " : " + value);
        // }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            String key =  entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
