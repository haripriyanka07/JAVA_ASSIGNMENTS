package com.Assignment10.list;

public class SListIterator<T> {
    Node<T> currentNode;
    Node<T> head;
    public SListIterator(Node<T> head)
    {
        this.head=head;
    }

    public void setCurrentNode(){
        currentNode=head;
    }
    public boolean hasNext()
    {
        return currentNode != null;
    }
    public T next()
    {
        T data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
    public void insert(T data){

        Node<T> newNode=new Node<T>(data);
        Node<T> temp=currentNode;
        if(currentNode==null){
            currentNode=newNode;
            head=currentNode;
        }
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = null;
        }
    }
    public void remove()
    {
        if (currentNode == null || currentNode.next==null)
            throw new IllegalStateException("No elements to delete further");
        else {
            Node<T> temp=currentNode;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            T removedNode = temp.next.data;
            temp.next=null;
            System.out.println("removed node : "+removedNode);
        }

    }
}
