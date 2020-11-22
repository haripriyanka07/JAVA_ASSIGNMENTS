package com.error404;
import edu.duke.FileResource;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts){
        for(String s : resource.lines()){
            String str = s;
            str = str.replace(",", "");
            str = str.replace(".", "");
            String[] arrOfStr = str.split(" ", -1);
            System.out.println(arrOfStr[4]);
            for(int i =0;i<arrOfStr.length;i++){
                counts[arrOfStr[i].length()]++;
            }
        }
        for(int j=0;j<counts.length;j++){

            System.out.println(counts[j]);
        }
    }

    public static void main(String[] args) {
        WordLengths w = new WordLengths();
        FileResource fr = new FileResource("data/smallHamlet.txt");
        int count=0;
        for (String s : fr.words()){
            count++;
        }
        int[] counts = new int[count];
        w.countWordLengths(fr, counts);

    }
}
