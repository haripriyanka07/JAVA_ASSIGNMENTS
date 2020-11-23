import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Set {
    public static void main(String[] args) {
//        HashSet<Integer> set = new HashSet<Integer>();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(11);
        set.add(57);
        set.add(22);
        set.add(99);
        set.add(7);
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}
