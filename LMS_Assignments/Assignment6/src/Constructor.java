public class Constructor {
    Constructor(){
        this("OverLoad Parameter");
        System.out.println("Default Constructor");
    }
    Constructor(String str){
        System.out.println("Parameterized Constructor " + str);
    }

    public static void main(String[] args) {
        Constructor con = new Constructor();
    }
}
