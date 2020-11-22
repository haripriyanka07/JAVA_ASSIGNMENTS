import java.util.*;
/* timecomplexity and spacecomplexity O(n) */

public class Assignment2 {
    public static boolean check(String input){
        Set<Character> set = new HashSet<Character>();
        for (int index=0; index<input.length(); index++){
            if(Character.isLetter(input.charAt(index))){
                set.add(input.charAt(index));
            }
        }
        if(set.size() == 26){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = sc.nextLine();
        sc.close();
        System.out.println("Contains Alphabets: "+check(input));
    }
}
