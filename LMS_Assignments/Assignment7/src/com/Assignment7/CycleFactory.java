package com.Assignment7;
interface CycleInterface{
    void type();
}
class UniCycle implements CycleInterface{
    UniCycle(){
        System.out.println("unicycle constructor");
    }
    public void type(){
        System.out.println("Unicycle");
    }
}
class BiCycle implements CycleInterface{
    BiCycle(){
        System.out.println("BiCycle constructor");
    }
    public void type(){
        System.out.println("BiCycle");
    }
}
class TriCycle implements CycleInterface{
    TriCycle(){
        System.out.println("Tricycle constructor");
    }
    public void type(){
        System.out.println("Tricycle");
    }
}
class UniCycleFactory{
    public static UniCycle getUnicycle(){
        return new UniCycle();
    }
}
class BiCycleFactory{
    public static BiCycle getBicycle(){
        return new BiCycle();
    }
}
class TriCycleFactory{
    public static TriCycle gettricycle(){
        return new TriCycle();
    }
}
public class CycleFactory {
    public static void main(String[] args) {
        CycleInterface un = UniCycleFactory.getUnicycle();
        un.type();
        CycleInterface bi = BiCycleFactory.getBicycle();
        bi.type();
        CycleInterface tri = TriCycleFactory.gettricycle();
        tri.type();
    }
}
