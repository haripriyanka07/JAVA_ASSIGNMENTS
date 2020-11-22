package com.error404;

public class Part2 {
    public int howMany(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        int count = 0;
        String sub = stringb;
        while(true){
            if(startIndex > stringb.length() || startIndex < 0){
                break;
            }
            else{
                sub = sub.substring(startIndex+ stringa.length());
                startIndex = sub.indexOf(stringa);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Part2 check = new Part2();
        System.out.println(check.howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(check.howMany("AA", "ATAAAA"));
    }
}
