package com.error404;
import edu.duke.*;

public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        if (startIndex >= 0){
            int stopIndex = dna.indexOf(stopCodon, startIndex);
            if (stopIndex > 0) {
                int length = stopIndex - startIndex;
                if (length % 3 == 0) {
                    return stopIndex;
                }
            }
        }
        return dna.length();
    }
    public String findGene (String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex >= 0){
            int taaIndex = dna.indexOf("TAA", startIndex);
            int tagIndex = dna.indexOf("TAG", startIndex);
            int tgaIndex = dna.indexOf("TGA", startIndex);
            int stopIndex = dna.length();
            if (taaIndex > 0) {
                int length = taaIndex - startIndex;
                if (length % 3 == 0) {
                    stopIndex = Math.min(stopIndex, length);
                }
            }
            if (tagIndex >0){
                int length = tagIndex - startIndex;
                if(length%3==0){
                    stopIndex = Math.min(stopIndex, length);
                }
            }
            if (tgaIndex >0){
                int length = tgaIndex - startIndex;
                if(length%3==0){
                    stopIndex = Math.min(stopIndex, length);
                }
            }
            return dna.substring(startIndex, stopIndex+3);
        }
        return "";
    }
    public StorageResource getAllGenes (String dna){
        StorageResource genlist = new StorageResource();
        return genlist;
    }
    public StorageResource printAllGenes(String dna){
        int index = 0;
        StorageResource genlist = new StorageResource();
        while(true){
            int startIndex = dna.indexOf("ATG", index);
            Part1 find = new Part1();
            int stopIndex = find.findStopCodon(dna, startIndex, "TAA");
            index = stopIndex + 1;
            if(index > dna.length()){
                break;
            }
//            System.out.println(dna.substring(startIndex, stopIndex+3));
            genlist.add(dna.substring(startIndex, stopIndex+3));
        }
        return genlist;
    }

    public static void main(String[] args) {
        Part1 test = new Part1();
//        test.printAllGenes("AAAGATGTTTGGGAAATAAATGGGGTAA");
//        System.out.println(test.findGene("ATGTTTGGGAAATAGTAATGA"));
        StorageResource genes = test.printAllGenes("AAAGATGTTTGGGAAATAAATGGGGTAA");
        for(String g: genes.data()){
            System.out.println(g);
        }
    }
}
