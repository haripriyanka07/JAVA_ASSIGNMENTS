package hari.assignment.data;

public class data {
    int var1;
    char var2;
    public void print(){
        System.out.println("Integer variable "+ var1 );
        System.out.println("Character variable "+ var2);
    }
    public void printLocalVariables(){
        int local1;
        int local2;
        /* we can't use local variables as they do not have default values
        System.out.println("Integer variable "+ local1 );
        System.out.println("Character variable "+ local2);*/
    }
}
