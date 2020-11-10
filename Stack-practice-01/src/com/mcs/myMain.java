package com.mcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myMain {
    public static void main(String[] args) {

//        1.  Infix to Post fix notation Algorithm and implement it in java using your own linked list stack class.
//        Try different examples.
        String infix="A+B*C";
        char[] infixChArr=infix.toCharArray();

        MyStack<Character> operatorStack=new MyStack<>();
        for(int index=infixChArr.length-1; index>=0; index--){

//            operatorStack.push(infixChArr[index]);
        }
        operatorStack.printStack();

//        System.out.println("operatorStack.pop() = " + operatorStack.pop());



//        2.  Infix to Prefix notation Algorithm and implement it in java using your own linked list stack class. Try
//        different examples
    }



    public static boolean isCharOperator(char charIn){
//        String alphaList="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String number="0123456789";
//        String operator="^*/+-";
        return "^*/+-".contains(String.valueOf(charIn));

    }
    public static boolean isBracket(char charIn){
        return "{[(}])".contains(String.valueOf(charIn));
    }
    public static int getOperatorPriority(char charIn){
        int priority=0;
        switch (charIn){
            case '+' : case '-' :
                priority=1;
                break;
            case '*': case '/':
                priority=2;
                break;
            case '^':
                priority=3;
                break;
            default:
                priority=0;
        }
        return priority;
    }
}
