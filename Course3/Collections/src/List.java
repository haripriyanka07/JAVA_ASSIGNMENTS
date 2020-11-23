import java.util.*;

public class List {
    public void stack(){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(11);
        stack.push(57);
        stack.push(22);
        stack.push(99);
        stack.push(7);
        Iterator<Integer> itr = stack.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        stack.pop();
        itr = stack.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }
    public static void main(String[] args) {
//        ArrayList<Integer> col = new ArrayList<Integer>();
//        LinkedList<Integer> col = new LinkedList<Integer>();
        Vector<Integer> col = new Vector<Integer>();
        col.add(11);
        col.add(57);
        col.add(22);
        col.add(99);
        col.add(7);
        System.out.println(col);
        col.remove(3);
        System.out.println(col);
        List li = new List();
        li.stack();

    }
}
