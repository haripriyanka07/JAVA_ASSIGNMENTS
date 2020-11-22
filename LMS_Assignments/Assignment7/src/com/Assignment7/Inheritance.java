package com.Assignment7;
public class Inheritance {
    public static void main(String[] args) {
        Rodent[] rodents = new Rodent[3];
        rodents[0] = new Mouse();
        rodents[1] = new Gerbil();
        rodents[2] = new Hamster();
        for (Rodent r : rodents) {
            r.displayName();
            r.displayFeatures();
        }
    }
}
abstract class Rodent{
    Rodent() {
        System.out.println("Rodent Default Constructor.");
    }
    abstract void displayName();
    abstract void displayFeatures();
}
class Mouse extends Rodent{
    Mouse(){
        System.out.println("Mouse Default Constructor");
    }

    @Override
    void displayName() {
        System.out.println("Mouse");
    }

    @Override
    void displayFeatures() {
        System.out.println("Mouse features");
    }
}
class Gerbil extends Rodent{
    Gerbil(){
        System.out.println("Gerbil Default Constructor");
    }

    @Override
    void displayName() {
        System.out.println("Gerbil");
    }

    @Override
    void displayFeatures() {
        System.out.println("Gerbil features");
    }
}
class Hamster extends Rodent{
    Hamster(){
        System.out.println("Hamster Default Constructor");
    }

    @Override
    void displayName() {
        System.out.println("Hamster");
    }
    @Override
    void displayFeatures() {
        System.out.println("Hamster features");
    }
}
