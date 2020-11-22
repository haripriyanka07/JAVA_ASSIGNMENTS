package com.Assignment7;
class Cycle{
    Cycle(){
        System.out.println("Cycle Constructor");
    }
}
class UniCycles extends Cycle{
    UniCycles(){
        System.out.println("UniCycle Constructor");
    }
    void balance(){
        System.out.println("Balance method of UniCycle class.");
    }
}
class BiCycles extends Cycle{
    BiCycles(){
        System.out.println("BiCycle Constructor");
    }
    void balance(){
        System.out.println("Balance method of Bicycle class.");
    }
}
class TriCycles extends Cycle{
    TriCycles(){
        System.out.println("Tricycle Constructor");
    }
}
public class CycleBalance{
    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[3];
        cycles[0] = new UniCycles();
        cycles[1] = new BiCycles();
        cycles[2] = new TriCycles();
        /* if we try to run these we get error as balance method is not present
        cycles[0].balance();
        cycles[1].balance();
        cycles[2].balance();*/

//        try downcasting only to unicycle and bicycle as tricycle donot
//            have balance method which raises error
        ((UniCycles)cycles[0]).balance();
        ((BiCycles)cycles[1]).balance();
    }
}