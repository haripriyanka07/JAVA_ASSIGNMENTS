package com.Assignment7;
class OuterOne{
    class InnerOne{
        InnerOne(String str){
            System.out.println("ONE "+str);
        }
    }
}
class OuterTwo{
    class InnerTwo extends OuterOne.InnerOne{
        InnerTwo(OuterOne oo){
            oo.super("From inner class two");
            System.out.println("TWO ");
        }

    }
}
public class InnerClass {
    public static void main(String[] args) {
        OuterOne oo = new OuterOne();
        OuterTwo ot = new OuterTwo();
        OuterTwo.InnerTwo oi = ot.new InnerTwo(oo);
    }
}
