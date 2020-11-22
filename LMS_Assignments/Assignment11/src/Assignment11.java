import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Assignment11 {
    static void count(Map<Character, Integer> characters, String line) throws IOException{
        for(int i=0;i<line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                if(characters.containsKey(line.charAt(i))){
                    characters.put(line.charAt(i), characters.get(line.charAt(i))+1);
                }
                else{
                    characters.put(line.charAt(i), 1);
                }
            }
            FileWriter fw = new FileWriter("/home/hpriya/charactercount.txt");
            fw.write(characters.toString());
            fw.close();
        }
    }

    public static void main(String[] args) throws IOException{
        String path = "/home/hpriya/";
        String filename = path+args[0];
        System.out.println(filename);
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        Map<Character, Integer> characters = new HashMap<Character, Integer>();
        String line;
        while (sc.hasNextLine()){
            line = sc.nextLine();
            count(characters, line);
        }
    }
}
