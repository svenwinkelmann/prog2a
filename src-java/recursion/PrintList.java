package recursion;

import acm.program.ConsoleProgram;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PrintList extends ConsoleProgram {

    void printList(Queue<Integer> queue) {
        if (queue.isEmpty())   // base case
            return;

        int i = queue.poll();
        print(i + ", ");   // insertion order
        printList((queue));
        print(i + ", ");   // reverse order
    }

    @Override
    public void run() {
        setFont("Arial-bold-32");

        Queue<Integer> queue = new LinkedList<>();

        queue.add(4);
        queue.add(9);
        queue.add(2);
        queue.add(10);
        queue.add(34);
        queue.add(76);

        printList(queue);
    }
}
