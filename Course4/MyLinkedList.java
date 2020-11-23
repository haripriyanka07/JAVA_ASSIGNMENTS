
import java.util.AbstractList;

public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;
    public MyLinkedList() {
        head = new LLNode<E>(null);
        tail = new LLNode<E>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public boolean add(E element) {
        add(this.size(), element);
        return true;
    }
    public E get(int index) {
        if (index < 0 || index > size - 1 || size == 0) {
            throw new IndexOutOfBoundsException("Index out of bounds in get() method");
        }

        LLNode<E> node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;

    }

    public void add(int index, E element) {
        if (element == null) {
            throw new NullPointerException("'Data can not be null!");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds in 'add at index'");
        }

        LLNode<E> currentNode = head;
        LLNode<E> newNode = new LLNode<E>(element);
        for (int i=0; i < index; i++) {
            currentNode= currentNode.next;
        }

        newNode.prev = currentNode;
        newNode.next = currentNode.next;
        newNode.next.prev = newNode;
        currentNode.next = newNode;

        this.size++;

    }
    public int size() {
        return this.size;
    }
    public E remove(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException("Illegal index in remove() method.");
        }

        LLNode<E> nodeToRemove = head.next;
        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }

        E removedElement = nodeToRemove.data;
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev = null;
        nodeToRemove.next = null;

        this.size--;

        return removedElement;
    }
    public E set(int index, E element) {
        if (element == null) {
            throw new NullPointerException("'Data can not be null!");
        }

        if (index < 0 || index > this.size() - 1) {
            throw new IndexOutOfBoundsException("Index cannot be < 0 or > size minus 1");
        }

        LLNode<E> nodeToSet = head.next;
        for (int i = 0; i < index; i++) {
            nodeToSet = nodeToSet.next;
        }

        E old = nodeToSet.data;
        nodeToSet.data = element;

        return old;
    }

    public static void main(String[] args) {
        int LONG_LIST_LENGTH = 10;
        MyLinkedList<String> shortList = new MyLinkedList<String>();
        MyLinkedList<Integer> emptyList = new MyLinkedList<Integer>();
        MyLinkedList<Integer> longerList = new MyLinkedList<Integer>();
        MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
        shortList.add("A");
        shortList.add("B");
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list1.add(65);
        list1.add(21);
        list1.add(42);

//        testing
        try{
            emptyList.get(0);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Empty");
        }
    }
}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;
    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

}
