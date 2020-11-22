package com.error404;

public class Part1 {

    public String findSimpleGene(String dna){

        int startIndex = dna.indexOf("ATG");
        if (startIndex > 0){
            int stopIndex = dna.indexOf("TAA", startIndex);
            if (stopIndex > 0) {
                int length = stopIndex - startIndex;
                if (length % 3 == 0) {
                    return (dna.substring(startIndex, stopIndex + 3));
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String dna1 = "AA";
        String dna2 = "TTAGGATGAAASSSTTTAAGG";
        String dna3 = "TTAGGATG";
        String dna4 = "TTAGTTAA";
        String dna5 = "TTAGGATGAAAYYSSSTTTTAAGG";
        Part1 exp = new Part1();
        System.out.println(exp.findSimpleGene(dna1));
        System.out.println(exp.findSimpleGene(dna2));
        System.out.println(exp.findSimpleGene(dna3));
        System.out.println(exp.findSimpleGene(dna4));
        System.out.println(exp.findSimpleGene(dna5));
    }
}
