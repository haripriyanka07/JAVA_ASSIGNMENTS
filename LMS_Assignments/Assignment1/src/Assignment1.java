import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1{
//    method to search for files in that particular directory
    public void searchFiles(String path, String exp){
        File dir = new File(path);
        if(dir.listFiles() == null){
            return;
        }
        for(File f: dir.listFiles()){
//            checking whether it is a directory or not.
            if(f.isDirectory()){
//                if it is a directory then method is called again
                searchFiles(f.getAbsolutePath(), exp);
            }
            else{
                Pattern pattern = Pattern.compile(exp);
                Matcher matcher = pattern.matcher(f.getName());
                if(matcher.find()){
                    System.out.println("Matched File: "+f.getName()+" with path: "+f.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dir = new File("/home");
        File[] filesList = dir.listFiles();
        while(true){
            System.out.println("Enter your regular expression: ");
            String pattern = sc.next();
            if(pattern.equals("end")){
                break;
            }
            Assignment1 test = new Assignment1();
            test.searchFiles("/home", pattern);
        }
    }
}