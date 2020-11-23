import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Queue {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(11);
        queue.add(57);
        queue.add(22);
        queue.add(99);
        queue.add(7);
//        queue.addFirst(1);
//        queue.addLast(100);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
