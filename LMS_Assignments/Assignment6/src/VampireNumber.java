import java.util.HashSet;
import java.util.Set;

public class VampireNumber {
    public void permutations(String strNumber, String str, Set<String> hs){
        if(strNumber.length() == 0){
            hs.add(str);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String strnumb = str.substring(0, i)+str.substring(i+1);
            permutations(strnumb, str+ch, hs);
        }
    }
    public boolean isVampire(long number){
        String strNumber = String.valueOf(number);
        int len = String.valueOf(number).length();
        if(len%2!=0){
            return false;
        }
        Set<String> hs = new HashSet<>();
        String str= "";
        permutations(strNumber, str, hs);
        for(String ps: hs) {
            String sub1 = ps.substring(0, len / 2);
            String sub2 = ps.substring(len / 2);
            long first = Long.parseLong(sub1);
            long second = Long.parseLong(sub2);
            if (sub1.charAt(sub1.length() - 1) == '0' && sub2.charAt(sub2.length() - 1) == '0')
                return false;
            if (first * second == number)
                return true;
        }
        return false;
    }
    public void printVampireNumber(){
        System.out.println("First 100 Vampire numbers:\n");
        long start = 10;
        int count = 1;
        while(count <= 100){
            if(isVampire(start)){
                System.out.println(start);
                count++;
            }
            start++;
        }
    }
}

