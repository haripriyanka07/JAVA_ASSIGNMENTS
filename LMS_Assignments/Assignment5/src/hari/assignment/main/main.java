package hari.assignment.main;

import hari.assignment.data.data;
import hari.assignment.singleton.singleton;

public class main {
    public static void main(String[] args) {
        data data = new data();
        data.print();
        data.printLocalVariables();
        singleton s = new singleton();
        s.nonStaticMethod();
    }
}
