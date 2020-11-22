package com.error404;
import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.Arrays;

public class CharactersInPlay {
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> counts = new ArrayList<Integer>();

    public void update(String person){
        int index = names.indexOf(person);
        if(index == -1){
            names.add(person);
            counts.add(1);
        }
        else{
            int val = counts.get(index);
            counts.set(index, val+1);
        }
        findAllCharacters();

    }
    public void findAllCharacters(){
        FileResource fr = new FileResource("data/likeit.txt");

        for (String s: fr.lines()){
//            System.out.println(s);
            s = s.trim();
            String[] str = s.split("\\.\\s");
//            System.out.println(str[0]);
            if(str[0].length()>0) {
                int index = names.indexOf(str[0]);
                if (index == -1) {
                    names.add(str[0]);
                    counts.add(1);
                } else {
                    int val = counts.get(index);
                    counts.set(index, val + 1);
                }
            }
//            System.out.println("END");
        }
        int maxi = 0;
        int index = 0;
        for(int i=0;i<counts.size();i++){
            if(counts.get(i) >= 10 && counts.get(i) <=15){
                System.out.println(names.get(index));
            }
            if(maxi < counts.get(i)){
                maxi = counts.get(i);
                index = i;
            }
//            System.out.println(names.get(i)+ " " +counts.get(i));
        }
        System.out.println(counts.get(index)+ " " + names.get(index));
        System.out.println(counts.size() +"  "+ names.size());
    }

    public static void main(String[] args) {
        CharactersInPlay cip = new CharactersInPlay();
        cip.findAllCharacters();
    }

}
