import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Hari");
        map.put(2, "Priyanka");
        map.put(3, "Sunkari");
        map.put(4, "Anusuya");
//        System.out.println();
        for(Map.Entry<Integer, String> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
