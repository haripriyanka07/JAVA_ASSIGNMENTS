package com.error404;

public class Part3 {
    public boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }
    public boolean twoOccurrences(String stringa, String stringb){
        if ( isEmpty(stringa) || isEmpty(stringb)){
            return false;
        }
        int occurrence = stringb.split(stringa, -1).length-1;
        if (occurrence >= 2){
            return true;
        }
        else{
            return false;
        }
    }
    public String lastPart(String stringa, String stringb){
        if (isEmpty(stringa) || isEmpty(stringb)){
            return "";
        }
        int index = stringb.indexOf(stringa);
        if ( index > 0 && index+stringa.length() < stringb.length()){
            return stringb.substring(index+stringa.length());
        }
        return stringb;
    }
    public static void main(String[] args) {
        String str1 = "A story by Abby Long";
        String str2 = "by";
        String str3 = "forest";
        String str4 = "zoo";
        Part3 check = new Part3();
        System.out.println(str1 + " " + check.twoOccurrences(str2, str1));
        System.out.println(check.lastPart(str4, str3));
    }
}
