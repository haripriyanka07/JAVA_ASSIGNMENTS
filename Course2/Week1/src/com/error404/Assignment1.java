package com.error404;

public class Assignment1 {

    public Boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' )
            return true;
        else
            return false;
    }
    public StringBuilder emphasize(String phrase, char ch){
        StringBuilder str = new StringBuilder(phrase);
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ch ){
                System.out.println((i+1)%2);
                if ((i+1)%2 == 0){
                    str.setCharAt(i, '+');
//                    phrase = phrase.replace(phrase.charAt(i), '+');
                }
                else{
                    str.setCharAt(i, '*');
//                    phrase = phrase.replace(phrase.charAt(i), '*');
                }
            }
        }
        return str;
    }
    public String replaceVowels(String phrase, char ch){
        for (int i=0;i<phrase.length();i++){
            if (isVowel(phrase.charAt(i))){
                phrase = phrase.replace(phrase.charAt(i), ch);
            }
        }
        return phrase;
    }

    public static void main(String[] args) {
        Assignment1 main = new Assignment1();
        System.out.println(main.isVowel('m'));
        System.out.println(main.replaceVowels("Hello World", '*'));
        System.out.println(main.emphasize("dna ctgaaactga", 'a'));
	// write your code here
    }
}
