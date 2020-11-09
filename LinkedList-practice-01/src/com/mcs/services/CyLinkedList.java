package com.mcs.services;


public class CyLinkedList {
//    public class Node{
//        public int value;
//        public Node next;
//        public Node(int value) {//constructor of Node class
//            this.value = value;
//            this.next = null;
//        }
//    }

    public Node first;
    public Node last;
    public int size;
    public Node middleNodeFound1 =null;
    public Node middleNodeFound2=null;
    private String nodeEmptyMessage=">>> Node is EMPTY, please add a node(s)";

    public CyLinkedList(){
        this.first=null;
        this.last=null;
        this.size=0;
    }

    public void descendingOrder() throws Exception {
        //Assignment 5
        if(isEmpty()) throw new Exception(nodeEmptyMessage);
        int totalCount=1;
        Node currentNode;
        Node nextNode;
        Node previousNode;
        for(int count=1; count <= totalCount; count++){
            currentNode=first;
            previousNode=null;
            System.out.println("count = " + count);
            while(currentNode!=null){
                nextNode=currentNode.next;
                if(nextNode!=null){
                    currentNode=swapNodesDesc(previousNode, currentNode, nextNode); //swap the linked node descending
                    // order
                }else{
                    last=currentNode;
                }
                printLinkedList();

                previousNode=currentNode;
                currentNode=currentNode.next;
                if(count==1) totalCount++; //total size of linked list
            }
//            last=currentNode;
            if(count==1) totalCount-=2; //set total size for for loop, one time set up in the first iteration.
//            System.out.println("totalCount = " + totalCount);
        }

        System.out.println("");
        System.out.println("----------------------------------------------------------");

    }
    public Node swapNodesDesc (Node previous, Node current, Node nextNode){
//        Node tempNode;
        //swap current node and next node in descending order, and returns current node after swapping
        if (previous==null){
            if(current.value <= nextNode.value){
                current.next=nextNode.next;
                nextNode.next=current;
                first=nextNode;

                return nextNode;
           }else{
                return current;
            }
       }else {
           if (current.value <= nextNode.value){
               current.next=nextNode.next;
               nextNode.next=current;
               previous.next=nextNode;

               return nextNode;
           }else{
               return current;
           }

       }

    }

    public void swapNodesValues(Node node, Node nextNode, boolean isAscending){
        if (isAscending){
            if (node.value>nextNode.value){
                node.value=nextNode.value+node.value;
                nextNode.value=node.value-nextNode.value;
                node.value=node.value-nextNode.value;
            }
        }else{
            if(node.value<nextNode.value){
                node.value=nextNode.value+node.value;
                nextNode.value=node.value-nextNode.value;
                node.value=node.value-nextNode.value;
            }
        }
    }

    public boolean isPalendrome() throws Exception {
        //assignment 4
        if(isEmpty()) throw new Exception(nodeEmptyMessage);
        Node currentNode=first;
        boolean isPalendromeInStep=true;
        int nthFromEnd=1;
//        int tempNUm;
        while (currentNode!=null){
//            System.out.println("-----------------------------");
//            System.out.println("currentNode.value = " + currentNode.value);
//            tempNUm=kthValueFromTheEnd(nthFromEnd);
            if(currentNode.value!=kthValueFromTheEnd(nthFromEnd)){ // if(currentNode.value!=tempNUm){
                isPalendromeInStep=false;
            }
//            System.out.println("currentNode.value!=kthValueFromTheEnd(nthFromEnd) = "
//                    + (currentNode.value == tempNUm));
            currentNode=currentNode.next;
            nthFromEnd++;
        }
//        System.out.println("isPalendromeInStep = " + isPalendromeInStep);
        return isPalendromeInStep;
    }

    public boolean isLinkedListPalendrome() throws Exception {
        //assignment 4

        if(isEmpty()) throw new Exception(nodeEmptyMessage);

        last=first; //change first to last before reverse it, other wise, last will not be changed
        Node currentNode=first;
        int numInList=0, reversedNum=0;//, tempNum=0;
        int tenToTheNthPower=1;
        while(currentNode!=null){
//            tempNum=numInList;
//            tempNum=tempNum*10;
            numInList=(numInList*10)+currentNode.value;
//            System.out.println("currentNode.value = " + currentNode.value + "\tsource Number = "+numInList);
            reversedNum=reversedNum+(tenToTheNthPower * currentNode.value);
            currentNode=currentNode.next;
            tenToTheNthPower*=10;
        }
        System.out.println("sourceNum = " + numInList);
        System.out.println("reversedNum = " + reversedNum);

        return numInList==reversedNum;
    }


    public boolean isListPalindrome() throws Exception {
        //assignment 4
        if (isEmpty())  throw new Exception(nodeEmptyMessage);
        String beforeReverse="";
        String afterReverse="";
        Node currentNode=first;
        while(currentNode!=null){
            System.out.println(currentNode.value);
            beforeReverse=beforeReverse+currentNode.value;
            afterReverse=currentNode.value+afterReverse;
            currentNode=currentNode.next;
        }
        System.out.println(beforeReverse);
        System.out.println(afterReverse);
        System.out.println(beforeReverse.equals(afterReverse));
        return beforeReverse.equals(afterReverse);
    }

    public void findMiddleOfLinkList() throws Exception{
        //assignment 3
        Node guideNode=first;
        Node middleNode=first;
        int guideCount=1;
        if (isEmpty())  throw new Exception(nodeEmptyMessage);
        while(guideNode!=null){
            if(((float)guideCount/2.0f) > 1.0f && guideCount%2==1) {
                middleNode = middleNode.next;
            }
            guideNode=guideNode.next;
            guideCount++;
        }
        if ((guideCount-1)>2){
            if ((guideCount-1)%2==0){
                middleNodeFound1 = middleNode;
                middleNodeFound2 = middleNode.next;
                System.out.println("\t> Middle Node 1 Val = "+ middleNodeFound1.value);
                System.out.println("\t> Middle Node 2 Val = "+middleNodeFound2.value);

            }else{
                middleNodeFound1 = middleNode;
                System.out.println("\t> Middle Node  Val = "+ middleNodeFound1.value);
//                System.out.println("\t> Middle Node 2 Val = "+nodeFound2);


            }
        }
//        while(guideNode!=null){
//
//            if(((float)guideCount/2.0f) > 1.0f && guideCount%2==1) {
////                middleCount++;
//                middleNode = middleNode.next;
////                System.out.println("Guide Node Value = " + guideNode.value + "\t Middle Node Val = " + middleNode.value);
//
//            }//else if(((float)guideCount/2.0f) > 1.0f && guideCount%2==0){
////                middleCount++;
////                System.out.println("Guide Node Value = "+guideNode.value+"\t Middle Node Val = "+middleNode.value);
////                System.out.println("Guide Node Value = "+guideNode.value+"\t Middle Node 1 Val = "+middleNode.value);
////                System.out.println("Guide Node Value = "+guideNode.value+"\t Middle Node 2 Val = "+middleNode.next.value);
//////                middleNode=middleNode.next;
////
////            }
////            System.out.println("Guide Node Value = "+guideNode.value+"\t Middle Node Val = "+middleNode.value);
//            guideNode=guideNode.next;
//            guideCount++;
//        }
//        System.out.println("");
//        System.out.println("total guide moved = "+(guideCount-1));

    }

    public int kthValueFromTheEnd(int index){
        //assignment 2
        Node guideNode = first;
        Node kthNode = first;
        int count=0;
        while(guideNode!=null){
            if(count>=index){
                kthNode=kthNode.next;
            }
            guideNode=guideNode.next;
            count++;
        }
        System.out.println("\t> Find ["+index+"]"+((index==1)?"st":(index==2)?"nd":(index==3)?"rd":"th")+" value from the end");
        System.out.println("\t> ["+index+"]"+((index==1)?"st":(index==2)?"nd":(index==3)?"rd":"th")+" Value = "+kthNode.value);

        return kthNode.value;
    }

    public void reverseSingly() throws Exception {
        //assignment 1

        if(isEmpty()) throw new Exception(nodeEmptyMessage);
        
        last=first; //change first to last before reverse it, other wise, last will not be changed
        Node previousNode=null;
        Node currentNode=first;// 0. reference currentNode to first, currentNode => 1
        Node nextNode;
        while(currentNode!=null){
                                            //0. 1 2 3 4 5  ,
            nextNode=currentNode.next;      //1. reference current node.next to next node, nextNode => 2
            currentNode.next=previousNode;  //2. reverse reference of current node to previous node, 1.next => null
            previousNode=currentNode;       //3. reference previous node to current node, previousNode => 1
            currentNode=nextNode;           //4. reference current node to next node, currentNode => 2
            first=previousNode; //change first node //5. set first to previous node
            printLinkedList();

        }
//        first=previousNode;

//        System.out.println(previousNode);
//        System.out.println(currentNode.value);
//        System.out.println(nextNode );
//        System.out.println("");
// -----------------------------------------------------
//        nextNode=currentNode.next;
//        currentNode.next=previousNode;
//        previousNode=currentNode;
//        System.out.println(">>> "+currentNode.next);
//        currentNode=nextNode;

//        System.out.println("prev: "+previousNode.value);
//        System.out.println("curr: "+currentNode.value);
//        System.out.println("next: "+nextNode.value );
//        System.out.println("");
//---------------------------------------------------------
//        nextNode=currentNode.next;
//        currentNode.next=previousNode;
//        previousNode=currentNode;
//        System.out.println(">>> "+currentNode.next.value);
//        currentNode=nextNode;
//
//        System.out.println("prev: "+previousNode.value);
//        System.out.println("curr: "+currentNode.value);
//        System.out.println("next: "+nextNode.value );
//---------------------------------------------------------
//        nextNode=currentNode.next;
//        currentNode.next=previousNode;
//        previousNode=currentNode;
//        System.out.println(">>> "+currentNode.next.value);
//        currentNode=nextNode;
//
//        System.out.println("prev: "+previousNode.value);
//        System.out.println("curr: "+currentNode);
//        System.out.println("next: "+nextNode );
//
//
//
//        System.out.println("---------------");

    }
/*--------------------------------------------------------------------------------------------- */
    public boolean isEmpty(){
        return first==null;
    }

    public void addLast(int item){
        Node newNode=new Node(item);
//        var newNode=new Node(item); //jdk 13
        System.out.println("\tadding an item : "+item);
        if (isEmpty()){
            first=last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
//        System.out.println(first.value);
//        System.out.println(last.value);
        size++;
    }
    public void deleteLast() throws Exception {
        if (isEmpty()) throw new Exception(nodeEmptyMessage);;

        System.out.println("\tdeleting an item from the last!");

        if (first==last){//only one node exist
            first=last=null;
        }else{
//          var previous=first;
          Node previous=first;
          Node current=first;
          while(current.next!=null){
              previous=current;
              current=current.next;
          }
          previous.next=null;
          last=previous;
        }
        size--;
    }
    public void printLinkedList() throws Exception {
        if (isEmpty()) throw new Exception(nodeEmptyMessage);;
        Node current=first;
        System.out.print(" >>> FIRST = "+first.value+" >>> ");
        while(current!=null){
            System.out.print("["+current.value+"] -> ");
            current=current.next;
        }
//        System.out.println(last.next);

        System.out.println((last.next==null)?last.next:last.value+" >>> LAST = "+last.value);

    }

}
