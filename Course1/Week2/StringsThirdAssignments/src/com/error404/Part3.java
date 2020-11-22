package com.error404;
import edu.duke.*;
public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        if (startIndex >= 0){
            int stopIndex = dna.indexOf(stopCodon, startIndex);
            while (stopIndex > 0) {
                int length = stopIndex - startIndex;
                if (length % 3 == 0) {
                    return stopIndex;
                }
                else{
                    stopIndex = dna.indexOf(stopCodon, stopIndex+1);
                }
            }
        }
        return dna.length();
    }
    public void processGenes(StorageResource sr){
        int count = 0;
        int count2 = 0;
        int len = 0;
        for(String s: sr.data()){
            len = Math.max(len, s.length());
            if (s.length()>60){
                System.out.println("String which has length more than 9 " +s);
                count++;
            }
            if(cgRatio(s)>0.35){
                count2++;
                System.out.println("String which has ratio more than 0.35 "+ s);
            }
        }
        System.out.println(count);
        System.out.println(count2);
        System.out.println(len);
    }
    public String findGene (String dna, int startIndex){
//        int startIndex = dna.toUpperCase().indexOf("ATG");
        dna = dna.toUpperCase();
        int index = dna.indexOf("ATG", startIndex);
        if(index == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, index, "TAA");
        int tagIndex = findStopCodon(dna, index, "TAG");
        int tgaIndex = findStopCodon(dna, index, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if(minIndex == dna.length()){
            return "";
        }
        return dna.substring(index, minIndex+3);
//            System.out.println(taaIndex);
//            if (taaIndex > 0) {
//                int length = taaIndex - startIndex;
//                if (length % 3 == 0) {
//                    stopIndex = Math.min(stopIndex, length);
//                }
//            }
//            if (tagIndex >0){
//                int length = tagIndex - startIndex;
//                if(length%3==0){
//                    stopIndex = Math.min(stopIndex, length);
//                }
//            }
//            if (tgaIndex >0){
//                int length = tgaIndex - startIndex;
//                if(length%3==0){
//                    stopIndex = Math.min(stopIndex, length);
//                }
//            }
//            System.out.println("TAA"+taaIndex);
//            System.out.println("TAG"+tagIndex);
//            System.out.println("TGA"+tgaIndex);
//            System.out.println(stopIndex);
//            System.out.println("YES "+Math.min(taaIndex, Math.min(tagIndex, tgaIndex)));
//            return Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
////            return dna.substring(startIndex, stopIndex+3);
//        }
//        return -1;
    }
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
    public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource genes = new StorageResource();
////        System.out.println(dna.indexOf("taa"));
//        int index = dna.indexOf("atg");
//        String sub = dna;
//        int stopIndex = 0;
        while(true){
            String str = findGene(dna, startIndex);
            if(str.isEmpty()){
                break;
            }
            genes.add(str);
            startIndex = dna.indexOf(str, startIndex+1)+str.length();
        }
        return genes;
//            if(index > sub.length()){
//                break;
//            }
////            int start = sub.indexOf("atg");
//            sub = sub.substring(index);
//            stopIndex = findGene(sub);
//            String str = sub.substring(index, stopIndex+3);
//            System.out.println(sub.substring(index, stopIndex+3));
//            System.out.println("LEN " +stopIndex+ "STR "+str.length());
//            genes.add(sub.substring(index, stopIndex));
//            index = index + stopIndex + 3;
//        }
//        return genes;
    }

    public static void main(String[] args) {
//        StorageResource sr =new StorageResource();
//        sr.add("ATGTTTTTTTTTTTTTAA");
//        sr.add("ATGTAA");
//        sr.add("ATCCCGGGGG");
//        sr.add("AATTC");
        Part3 test = new Part3();
//        test.processGenes(sr);
//        System.out.println(test.cgRatio("ATCCCGGGG"));
        FileResource fr = new FileResource("data/brca1line.fa");
        StorageResource sr = test.getAllGenes(fr.asString());
        test.processGenes(sr);
//        for(String s : sr.data()){
//            System.out.println(s);
//            test.processGenes(s);
    }
}
