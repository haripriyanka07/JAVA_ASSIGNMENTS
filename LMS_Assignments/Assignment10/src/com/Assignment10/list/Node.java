package com.Assignment10.list;
/*
    @param T
    */
public class Node<T> {
    T data;
    Node<T> next;
    public Node(T t){
        this.data = t;
        this.next = null;
    }
}
