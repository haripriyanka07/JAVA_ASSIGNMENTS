package com.error404;

public class Main {
    public void findAbc(String input){
        int index = input.indexOf("abc");
        while (true){
            if (index == -1 || index >= input.length() - 3){
                break;
            }
//            System.out.println(index);
            String found = input.substring(index+1, index+4);
            System.out.println(found);
//            System.out.println(index);
//            System.out.println(input.substring(index+4));
            index = input.indexOf("abc",index+3);
//            System.out.println(index);
        }
    }

//    public void test(){
//        //findAbc("abcd");
//        findAbc("abcdabc");
//    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.findAbc("kdabcabcjei");
//        System.out.println("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj".lastIndexOf('a'));
    }
}
