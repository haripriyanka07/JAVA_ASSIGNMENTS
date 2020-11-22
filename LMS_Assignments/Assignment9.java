import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Assignment9 {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("^[A-Z].*[.]$");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter a string");
        if (pattern.matcher(bufferedReader.readLine()).find()) {
            System.out.println("The given input is valid.");
        }
        else {
            System.out.println("The given statement is invalid");
        }
    }
}
