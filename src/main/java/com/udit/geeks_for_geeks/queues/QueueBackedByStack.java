package com.udit.geeks_for_geeks.queues;

import java.util.Stack;

public class QueueBackedByStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String args[]) {
        /* Create a queue with items 1 2 3*/
        QueueBackedByStack q = new QueueBackedByStack();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        /* Dequeue items */
        System.out.print(q.deQueue() + " ");
        q.enQueue(8);
        System.out.print(q.deQueue() + " ");
        q.enQueue(7);
        System.out.println(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");
    }

    public void enQueue(int number) {
        stack1.push(number);
    }

    public Integer deQueue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return null;
    }
}
