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

    public void swap()
    {

    }
}
