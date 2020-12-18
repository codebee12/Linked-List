package com.company;

public class LinkedList {

    Node head;
    static class Node
    {
        Node next;
        int data;

        Node(int d)
        {
            this.data=d;
        }
    }


    public static void main(String[] args) {

	    //create a linkedList with 3 nodes
        LinkedList list = new LinkedList();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.head = first;
        first.next = second;
        second.next = third;
        third.next = null;

        list.traversal();

        Node zero = new Node(0);
        list.insertAtFront(zero);
        System.out.println("Linked List after inserting at the front...");
        list.traversal();

        Node four = new Node(4);
        list.insertAtEnd(four);
        System.out.println("Linked List after inserting at the end...");
        list.traversal();

        Node five = new Node(5);
        list.insertAtPosition(2,five);
        System.out.println("Linked List after inserting at position 2...");
        list.traversal();

        list.deleteNode(2);
        System.out.println("Linked List after deletion at position 1...");
        list.traversal();

        list.swapValues(2,3);
        System.out.println("Linked List after swapping...");
        list.traversal();

    }

    public void traversal()
    {
        Node node = this.head;
        while(node!=null)
        {
            System.out.print(node.data+"-->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void insertAtFront(Node node)
    {
        node.next = this.head;
        head = node;
    }

    public void insertAtEnd(Node node)
    {
        Node iterator = this.head;
        while(iterator.next!=null)
        {
            iterator = iterator.next;
        }
        iterator.next = node;
    }
    /*
    Covers position at front and end as well
     */
    public void insertAtPosition(int pos, Node node)
    {
        if(pos <1)
            return;
        if(pos == 1)
            insertAtFront(node);
        else
        {
            pos--;
            Node iterator = this.head;
            int i=1;
            while(iterator.next!= null && i!=pos)
            {
                iterator = iterator.next;
                i++;
            }
            node.next = iterator.next;
            iterator.next = node;
        }
    }

    public void deleteNode(int pos)
    {
        if(pos <1)
            return;
        if(pos == 1)
        {
            this.head = head.next;
        }
        else
        {
            pos--;
            Node iterator = this.head;
            int i=1;
            while(iterator.next!= null && i!=pos)
            {
                iterator = iterator.next;
                i++;
            }
            iterator.next = iterator.next.next;
        }
    }

    /*
    Swap values between two positions
     */
    public void swapValues(int pos1, int pos2)
    {
        if(pos1 <0 || pos2 < 0 || (pos1==pos2))
            return;
        else
        {
            Node iterator1 = this.head;
            Node iterator2 = this.head;
            int c1,c2;
            c1=c2=1;
//            pos1--;
//            pos2--;
            while(iterator1.next!=null && c1!=pos1)
            {
                iterator1 = iterator1.next;
                c1++;
            }
            while(iterator2.next!=null && c2!=pos2)
            {
                iterator2 = iterator2.next;
                c2++;
            }
            int temp = iterator1.data;
            iterator1.data = iterator2.data;
            iterator2.data = temp;
        }
    }
}
