
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Document {

    private String text;
    public Document(String text) {
        this.text = text;
    }
    public int getNumWords() {
        List<String> tokens = getTokens("[a-zA-Z]+");
        System.out.println(tokens);
        return tokens.size();
    }
    public int getNumSentences() {
        System.out.println(text);
        List<String> tokens = getTokens("[^?.!]+");
        System.out.println(tokens);
        return tokens.size();
    }
    public List<String> getTokens(String pattern) {
        ArrayList<String> tokens = new ArrayList<String>();
        Pattern tokSplitter = Pattern.compile(pattern);
        Matcher m = tokSplitter.matcher(text);

        while (m.find()) {
            tokens.add(m.group());
        }

        return tokens;
    }
    public static void main(String[] args) {
        Document t =new Document("This is a test.  How many???  Senteeeeeeeeeences are here... there should be 5!  Right?");
        System.out.println(t.getNumSentences());
        System.out.println(t.getNumWords());
    }

}
