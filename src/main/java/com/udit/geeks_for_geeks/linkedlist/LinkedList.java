/* * Copyright 2017 Autodesk, Inc. All Rights Reserved.
 *
 * This computer source code and related instructions and comments 
 * are the unpublished confidential and proprietary information of Autodesk, Inc. 
 * and are protected under applicable copyright and trade secret law.  
 * They may not be disclosed to, copied or used by any third party without the prior 
 * written consent of Autodesk, Inc.
 */

package com.udit.geeks_for_geeks.linkedlist;

/**
 * @author Udit Sharma.
 * @since 19 Jan, 2018 12:40 AM
 */
public class LinkedList {
    Node head;

    public static void main(String[] args) {
/* Start with the empty list */
        LinkedList llist = new LinkedList();

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();
    /*System.out.println("llist.lengthIterative() = " + llist.lengthIterative());
    System.out.println("llist.lengthRecursive() = " + llist.lengthRecursive());

    llist.deleteNode(4);  // Delete node at position 4

    System.out.println("\nLinked List after Deletion at position 4: ");
    llist.printList();

    System.out.println("llist.lengthIterative() = " + llist.lengthIterative());
    System.out.println("llist.lengthRecursive() = " + llist.lengthRecursive());
*/
        llist.reverse();

        llist.printList();

        LinkedList llist1 = new LinkedList();
        llist1.push(20);
        llist1.push(13);
        llist1.push(13);
        llist1.push(11);
        llist1.push(11);
        llist1.push(11);

        System.out.println("List before removal of duplicates");
        llist1.printList();

        llist1.removeDuplicates();

        System.out.println("List after removal of elements");
        llist1.printList();

    }

    void push(int data) {
        Node node = new Node(data);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    void insertAfter(Node node, int data) {
        if (node != null) {
            Node dataNode = new Node(data);
            dataNode.next = node.next;
            node.next = dataNode;
        }
    }

    void append(int data) {
        Node node = new Node(data);
        if (head != null) {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        } else {
            head = node;
        }
    }

    void delete(int key) {
        if (head != null) {
            if (head.data == key) {
                head = head.next;
                return;
            }
            Node curr = head;
            Node prev = null;

            while (curr != null && curr.data != key) {
                prev = curr;
                curr = curr.next;
            }

            if (curr != null) {
                prev.next = curr.next;
                curr.next = null;
            }
        }
    }

    void deleteNode(int pos) {
        if (head != null) {
            if (pos == 0) {
                head = head.next;
            } else {
                Node curr = head, prev = null;
                int i = 0;
                while (i < pos && curr != null) {
                    prev = curr;
                    curr = curr.next;
                    i++;
                }
                if (curr != null) {
                    prev.next = curr.next;
                    curr.next = null;
                }
            }
        }
    }

    int lengthIterative() {
        return _lengthIterative(head);
    }

    private int _lengthIterative(Node curr) {
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    int lengthRecursive() {
        int length = 0;
        Node curr = head;
        return _lengthRecursive(curr);
    }

    private int _lengthRecursive(Node curr) {
        if (curr == null) {
            return 0;
        }
        return 1 + _lengthRecursive(curr.next);
    }

    boolean searchIterative(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    boolean searchRecursive(int data) {
        Node temp = head;
        return _searchRecursive(temp, data);
    }

    private boolean _searchRecursive(Node temp, int data) {
        if (temp != null) {
            if (temp.data == data) {
                return true;
            }
            _searchRecursive(temp.next, data);
        }
        return false;
    }

    public void reverse() {
        _reverse(head, null);
    }

    private void _reverse(Node curr, Node prev) {

        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return;
        }
        _reverse(curr.next, curr);
        curr.next = prev;
    }

    boolean detectLoop() {
        Node slowPointer = head, fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
    }

    public void printMiddle() {
        if (head != null) {
            Node fastPointer = head, slowPointer = head;
            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
            System.out.println("Print Middle : " + slowPointer.data);
        }
    }

    public int getInterSectionNode(Node head, Node head2) {
        int size = _lengthRecursive(head);
        int size2 = _lengthIterative(head2);
        int diff = Math.abs((size - size2));
        if (size > size2) {
            for (int i = 0; i < diff; i++) {
                head = head.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        while (head != null && head2 != null) {
            if (head.data == head2.data) {
                return diff;
            }
            diff++;
        }
        return -1;
    }

    void removeDuplicates() {
        if (head != null) {
            Node curr = head;
            while (curr.next != null) {
                if (curr.data == curr.next.data) {
                    Node temp = curr.next.next;
                    curr.next.next = null;
                    curr.next = temp;
                } else {
                    curr = curr.next;
                }
            }
        }
    }

    LinkedList interSect(Node head, Node head2) {
        LinkedList list = new LinkedList();
        if (head != null && head2 != null) {
            while (head != null && head2 != null) {
                if (head.data == head2.data) {
                    list.append(head.data);
                }
                head = head.next;
                head2 = head2.next;
            }
        }
        return list;
    }
}
