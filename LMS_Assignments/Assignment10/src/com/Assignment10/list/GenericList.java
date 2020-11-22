package com.Assignment10.list;

public class GenericList {
    public static void main(String[] args) {
        SList <Integer> list = new SList<Integer>();
        SListIterator<Integer> sListIterator = list.iterator();
        sListIterator.insert(1);
        sListIterator.insert(3);
        sListIterator.insert(4);
        sListIterator.insert(5);
        sListIterator.insert(6);
        System.out.println(list);
        sListIterator.remove();
        sListIterator.remove();
        sListIterator.remove();
        System.out.println(list);
    }
}
