package com.error404;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        myFreqs.clear();
        myWords.clear();
        System.out.println("R");
        FileResource resource = new FileResource("data/likeit.txt");
        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s.toLowerCase());
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int val = myFreqs.get(index);
                myFreqs.set(index, val+1);
            }
        }
//        System.out.println(myWords);
    }
    public void test(){
        findUnique();
        int maxi =0;
        int index = 0;
//        System.out.println(myFreqs);
        for(int i=0;i<myWords.size();i++){
            if(maxi < myFreqs.get(i)){
                maxi = myFreqs.get(i);
                index = i;
            }
//            System.out.println(myFreqs.get(i)+ " " +myWords.get(i));
        }
        System.out.println(myFreqs.get(index)+ " " + myWords.get(index));
        System.out.println(myFreqs.size() +"  "+ myWords.size());
    }

    public static void main(String[] args) {
        WordFrequencies wf = new WordFrequencies();
//        wf.findUnique();
      wf.test();
    }
}
