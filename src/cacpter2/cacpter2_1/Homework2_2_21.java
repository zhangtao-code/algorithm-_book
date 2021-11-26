package cacpter2.cacpter2_1;

import java.util.*;

public class Homework2_2_21 {
    public static void main(String[] args) {
        List<Set<String>>list=new ArrayList<>();
        Set<String>set1=new HashSet<>();
        set1.add("rwqe");
        set1.add("34ww");
        set1.add("rtew");
        set1.add("mjkf1");
        list.add(set1);
        Set<String>set2=new HashSet<>();
        set2.add("wfqe");
        set2.add("3ff4");
        set2.add("rtew1");
        set2.add("mjkf");
        list.add(set2);
        Set<String>set3=new HashSet<>();
        set3.add("wfqedcfcsd");
        set3.add("3ff41");
        set3.add("rteedfsw1");
        set3.add("mjkf");
        list.add(set3);
        System.out.println(search(list));
    }

    public static String search(List<Set<String>>list) {
        BitSet bitSet=new BitSet();
        for (Set<String> set : list) {
            for (String item : set) {
               int hashcode=item.hashCode()&Integer.MAX_VALUE;
                if(bitSet.get(hashcode)){
                    return item;
                }
                bitSet.set(hashcode);
            }
        }
        return null;
    }
}
