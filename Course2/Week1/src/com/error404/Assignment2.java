package com.error404;
import edu.duke.*;
public class Assignment2 {

    public String encrypt(String input, int key){
        StringBuilder encrypt = new StringBuilder(input);

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();

        String upperShift = upper.substring(key) + upper.substring(0, key);
        String lowerShift = lower.substring(key) + lower.substring(0, key);

        for (int i=0;i<encrypt.length();i++){
            char currentChar = encrypt.charAt(i);

            if(Character.isUpperCase(currentChar)){
                int index = upper.indexOf(currentChar);
                if (index != -1) {
                    char newchar = upperShift.charAt(index);
                    encrypt.setCharAt(i, newchar);
                }
            }
            else{
                int index = lower.indexOf(currentChar);
                if (index != -1){
                    char newchar = lowerShift.charAt(index);
                    encrypt.setCharAt(i, newchar);
                }
            }
        }
        return encrypt.toString();
    }
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    public String encryptTwoKeys(String phrase, int key1, int key2){
//        StringBuilder input = new StringBuilder(phrase);
        String sub = phrase.substring(0);
        for(int i =0;i<phrase.length();i++){

            if((i+1)%2 == 0){
                sub = Character.toString(phrase.charAt(i));
                phrase = phrase.substring(0, i)+encrypt(sub, key2)+phrase.substring(i+1);

            }
            else{
                sub = Character.toString(phrase.charAt(i));
                phrase = phrase.substring(0, i)+encrypt(sub, key1)+phrase.substring(i+1);
//                phrase = encrypt(phrase, key2);
            }
        }

        return phrase.toString();
    }

    public static void main(String[] args) {
        Assignment2 test =new Assignment2();
//        test.testCaesar();
//        System.out.println(test.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(test.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(test.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
        System.out.println(test.encryptTwoKeys("First Legion", 17, 23));

    }
}
