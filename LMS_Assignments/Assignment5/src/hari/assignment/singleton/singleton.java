package hari.assignment.singleton;

public class singleton {
    String str;
    public static singleton staticMethod(String str){
        singleton s = new singleton();
        s.str = str;
        return s;
    }
    public void nonStaticMethod(){
        System.out.println(str);
    }
}
