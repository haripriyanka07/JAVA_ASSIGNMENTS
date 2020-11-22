package com.error404;

public class Part3 {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        System.out.println(startIndex +" "+dna+" "+ stopCodon);
        if (startIndex >= 0){
            int stopIndex = dna.indexOf(stopCodon, startIndex);
            System.out.println(stopIndex);
            if (stopIndex > 0) {
                int length = stopIndex - startIndex;
                if (length % 3 == 0) {
                    return stopIndex;
                }
            }
        }
        return dna.length();
    }
    public int findGene (String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex >= 0){
            int taaIndex = dna.indexOf("TAA", startIndex);
            int tagIndex = dna.indexOf("TAG", startIndex);
            int tgaIndex = dna.indexOf("TGA", startIndex);
            int stopIndex = dna.length();
            if (taaIndex > 0) {
                int length = taaIndex - startIndex;
                if (length % 3 == 0) {
                    stopIndex = Math.min(stopIndex, taaIndex);
                }
            }
            if (tagIndex >0){
                int length = tagIndex - startIndex;
                if(length%3==0){
                    stopIndex = Math.min(stopIndex, tagIndex);
                }
            }
            if (tgaIndex >0){
                int length = tgaIndex - startIndex;
                if(length%3==0){
                    stopIndex = Math.min(stopIndex, tgaIndex);
                }
            }
//            System.out.println(stopIndex);
//            System.out.println(startIndex+" "+ stopIndex);
            System.out.println(dna.substring(startIndex, stopIndex+3));
            return stopIndex+3;
        }
        return -1;
    }

    public int countGene(String dna){
        int count = 0;
        while(true) {
            Part3 find = new Part3();
            int index = find.findGene(dna);
            if (index > 0 && index < dna.length()) {
                count++;
                dna = dna.substring(index);
            }
            else{
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Part3 check = new Part3();
        System.out.println(check.countGene("AATGCTAACTAGCTGACTAAT"));
    }
}
