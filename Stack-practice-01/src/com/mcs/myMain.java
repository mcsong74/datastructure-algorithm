package com.mcs;

public class myMain {
    public static void main(String[] args) {

//        1.  Infix to Post fix notation Algorithm and implement it in java using your own linked list stack class.
//        Try different examples.
        String infix="A+B*C";
        char[] infixChArr=infix.toCharArray();
        MyStack<Character> operatorStack=new MyStack<>();
        for(int index=infixChArr.length-1; index>=0; index--){
            operatorStack.push(infixChArr[index]);
        }

//        System.out.println("operatorStack.pop() = " + operatorStack.pop());
        System.out.println("operatorStack.size() = " + operatorStack.size());
        System.out.println("operatorStack.getBottom() = " + operatorStack.getBottom());
        System.out.println("operatorStack.getTop() = " + operatorStack.getTop());

        operatorStack.printStack();


//        2.  Infix to Prefix notation Algorithm and implement it in java using your own linked list stack class. Try
//        different examples.


    }
}
