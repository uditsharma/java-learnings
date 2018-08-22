/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.queues;

/**
 * @author Udit Sharma.
 * @since 27 Feb, 2018 11:14 PM
 */
public class Queue {
    int[] values;
    int front, rear, size;
    int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(1000);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.deQueue() + " dequeued from queue\n");

        System.out.println("Front item is " + queue.front());

        System.out.println("Rear item is " + queue.rear());
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        size++;
        values[rear] = data;
    }

    int deQueue() {
        int data = values[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    int front() {
        if (!isEmpty()) {
            return values[front];
        }
        return -1;
    }

    int rear() {
        if (!isEmpty()) {
            return values[rear];
        }
        return -1;
    }


}
