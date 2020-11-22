package com.error404;

public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon){

        int startIndex = dna.indexOf(startCodon);
        if (startIndex > 0){
            int stopIndex = dna.indexOf(stopCodon, startIndex);
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
        String dna2 = "TTAGGATGAAASSSTTTTAAGG";
        String dna3 = "TTAGGATG";
        String dna4 = "TTAGTTAA";
        String dna5 = "TTAGGATGAAAYYSSSTTTTAAGG";
        Part2 exp = new Part2();
        System.out.println(exp.findSimpleGene(dna1, "ATG", "TAA"));
        System.out.println(exp.findSimpleGene(dna2, "ATG", "TAA"));
        System.out.println(exp.findSimpleGene(dna3, "ATG", "TAA"));
        System.out.println(exp.findSimpleGene(dna4, "ATG", "TAA"));
        System.out.println(exp.findSimpleGene(dna5, "ATG", "TAA"));
    }
}
