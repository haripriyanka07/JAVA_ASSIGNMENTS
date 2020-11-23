import java.util.*;
public class Trie {
    private TriesNode root;
    private int size;
    public Trie(){
        root = new TriesNode();
        size = 0;
    }
    public boolean add(String word){
        TriesNode trie = root;
        if(trie == null || word == null)
            return false;
        char[] chars = word.toCharArray();
        int count = 0;
        while(count < chars.length){
            Set childs = trie.getChildern().keySet();
            if(!childs.contains(chars[count])){
                insertChar(trie, chars[count]);
                if(count == chars.length-1){
                    getChild(trie, chars[count]).setIsWord(true);
                    size++;
                    return true;
                }
            }
            trie = getChild(trie, chars[count]);
            if(trie.getContent().equals(word) && !trie.isWord()){
                trie.setIsWord(true);
                size++;
                return true;
            }
            count++;
        }
        return false;
    }
    private TriesNode insertChar(TriesNode trie, Character ch){
        if(trie.getChildern().containsKey(ch)){
            return null;
        }
        TriesNode next = new TriesNode(trie.getContent()+ ch.toString());
        trie.getChildern().put(ch, next);
        return next;
    }
    private TriesNode getChild(TriesNode trie, Character ch){
        return trie.getChildern().get(ch);
    }
    public boolean find(String str){
        Map<Character, TriesNode> children = root.getChildern();
        TriesNode t =null;
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.getChildern();
            }
            else
                return false;
        }
        return true;
    }
    public boolean remove(String str){
        return findNode(root, str);
    }
    private boolean findNode(TriesNode trie, String s){
        Map<Character, TriesNode> childern = root.getChildern();
        TriesNode parent = null;
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(childern.containsKey(c)){
                parent = trie;
                trie = childern.get(c);
                childern = trie.getChildern();
                if(trie.getContent().equals(s)){
                    parent.getChildern().remove(c);
                    trie = null;
                    return true;
                }
            }
        }
        return false;
    }
    public int getSize(){
        return size;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("at");
        trie.add("Hello");
        trie.add("Been");
        trie.add("yes");
        trie.add("water");
        trie.add("be");

        trie.remove("water");
        System.out.println(trie.find("be"));
        System.out.println(trie.find("water"));
    }
}
class TriesNode{
    private HashMap<Character, TriesNode> childern;
    private String content;
    private boolean isWord;
    public TriesNode(){
        childern = new HashMap<Character, TriesNode>();
        content = "";
        isWord = false;
    }
    public TriesNode(String text){
        this();
        this.content = text;
    }
    public HashMap<Character, TriesNode> getChildern(){
        return childern;
    }
    public String getContent(){
        return content;
    }
    public Boolean isWord(){
        return isWord;
    }
    public void setIsWord(boolean word){
        isWord = word;
    }

    @Override
    public String toString(){
        return content;
    }
}
