package com.Assignment7;

interface Interface1{
    void interface1Method1();
    void interface1Method2();
}
interface Interface2{
    void interface2Method1();
    void interface2Method2();
}
interface Interface3{
    void interface3Method1();
    void interface3Method2();
}
interface Interface4 extends Interface1, Interface2, Interface3{
    void interface4Method();
}
class ConcreteClass{
    ConcreteClass(){
        System.out.println("Concrete Class");
    }
}
class Base extends ConcreteClass implements Interface4{

    void fetchInterface1(Interface1 base){
        base.interface1Method1();
        base.interface1Method2();
    }
    void fetchInterface2(Interface2 base){
        base.interface2Method1();
        base.interface2Method2();
    }
    void fetchInterface3(Interface3 base){
        base.interface3Method1();
        base.interface3Method2();
    }
    void fetchInterface4(Interface4 base){
        base.interface4Method();
    }

    @Override
    public void interface1Method1() {
        System.out.println("Inside interface 1 method 1");
    }

    @Override
    public void interface1Method2() {
        System.out.println("Inside interface 1 method 2");
    }

    @Override
    public void interface2Method1() {
        System.out.println("Inside interface 2 method 1");
    }

    @Override
    public void interface2Method2() {
        System.out.println("Inside interface 2 method 2");
    }

    @Override
    public void interface3Method1() {
        System.out.println("Inside interface 3 method 1");
    }

    @Override
    public void interface3Method2() {
        System.out.println("Inside interface 3 method 2");
    }

    @Override
    public void interface4Method() {
        System.out.println("Inside interface 4 method");
    }
}
public class Interfaces {
    public static void main(String[] args) {
        Base base = new Base();
        base.fetchInterface1(base);
        base.fetchInterface2(base);
        base.fetchInterface3(base);
        base.fetchInterface4(base);
    }
}
