package com.mcs;

import com.mcs.services.CyLinkedList;

public class LinkedListRunner {
    public static void main(String[] args) throws Exception {
//        CyLinkedList myLink=new CyLinkedList();
//        myLink.addLast(1);
//        myLink.addLast(2);
//        myLink.addLast(6);
//        myLink.addLast(4);
//        myLink.addLast(2);
//        myLink.addLast(6);
//        myLink.addLast(11);
//        myLink.addLast(8);
//        myLink.addLast(9);
//        myLink.addLast(10);
//
//        myLink.printLinkedList();
//
//        //assignment 5
//        System.out.println("------------ 5. Sort singly linked list in descending order -------------");
//        myLink.descendingOrder();
//        myLink.printLinkedList();


        //assignment 4
        System.out.println("------------ 4. Check singly linked list is a Palindrome -------------");
        CyLinkedList myLink2=new CyLinkedList();
        myLink2.addLast(1);
        myLink2.addLast(2);
        myLink2.addLast(3);
        myLink2.addLast(2);
        myLink2.addLast(1);

        System.out.println(" >>> myLink2.isPalendrome() = " + myLink2.isPalendrome());

//        System.out.println("myLink2.isPalendrome() = " + myLink2.isLinkedListPalendrome());
//        myLink2.isListPalindrome();
        //assignment 3
//        System.out.println("------------ 3. find middle of Linked List -------------");
//        myLink.findMiddleOfLinkList();

        //assignment 2
//        System.out.println("------------ 2. find kth Node value -------------");
//        int k=3;
//        myLink.kthValueFromTheEnd(3);

        //assignment 1
        CyLinkedList myLink=new CyLinkedList();
        myLink.addLast(1);
        myLink.addLast(2);
        System.out.println("------------ 1. reverse -------------");
        myLink.reverseSingly();
        System.out.println("");
        myLink.printLinkedList();


        //        myLink.deleteLast();
//        myLink.printLinkedList();

//        1. Reversing the nodes of a singly linked lists in one pass.
//        2. Finding the Kth node from the end in one pass where you don’t know the
//        size of the list.
//        3. Find the middle of a linked list in one pass. If the list has an even number
//        of nodes, there would be two middle nodes. (Note: Assume that you don’t
//        know the size of the list ahead of time.)
//        Additional /Optional Exercises
//        4. Check the singly linked list if it is Palindrome (Without a stack)
//        5. Sort the singly linked list of integers in descending order without using any
//        sort algorithm.

    }
}
