package com.error404;

public class Part2 {
    public float cgRatio(String dna){
        float count = 0;
        int length = dna.length();
        for(int i=0;i<length;i++){
            char word = dna.charAt(i);
            if(word == 'C' || word == 'G'){
                count++;
            }
        }
        float val = count/length;
        return val;
    }

    public static void main(String[] args) {
        Part2 test = new Part2();
        System.out.println(test.cgRatio("ATGCCATAG"));
    }
}
