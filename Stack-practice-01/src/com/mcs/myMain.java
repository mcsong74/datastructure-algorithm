package com.mcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class myMain {
    public static void main(String[] args) {

//        1.  Infix to Post fix notation Algorithm and implement it in java using your own linked list stack class.
//        Try different examples.
        String infix="A * B + C / D";
        infix=infix.replaceAll("\\s", "");
        System.out.println("infix = " + infix);

        char[] infixChArr=infix.toCharArray();

        MyStack<Character> operatorStack=new MyStack<>();
        MyStack<Character> resultStack=new MyStack<>();
        for(int index=infixChArr.length-1; index>=0; index--){
            if(!isCharOperator(infixChArr[index])){
                resultStack.push(infixChArr[index]);
            }else if(isCharOperator(infixChArr[index])){
                if(operatorStack.isEmpty()){
                    operatorStack.push(infixChArr[index]);
                }else{
                    if(getOperatorPriority(operatorStack.getTop())>getOperatorPriority(infixChArr[index])){
                        resultStack.push(operatorStack.pop());
                        operatorStack.push(infixChArr[index]);
                    }else{
                        operatorStack.push(infixChArr[index]);
                    }
                }
            }else if (isBracket(infixChArr[index])){
                if(infixChArr[index]==')'){
                    operatorStack.push(infixChArr[index]);
                }else if(infixChArr[index]==')'){
                    while(operatorStack.getTop()!=')'){
                        resultStack.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                }

            }

        }
        while(!operatorStack.isEmpty()){
            resultStack.push(operatorStack.pop());
        }
        if (operatorStack.isEmpty())
            System.out.println("operatorStack = null");


        System.out.println("result stack in Array = "+Arrays.toString(resultStack.toArray()));
        System.out.println("Infix = ["+infix+"] to prefix = ["+resultStack.converStackToString()+"]");

//        System.out.println("operatorStack.pop() = " + operatorStack.pop());
//        System.out.println("getOperatorPriority() = " + getOperatorPriority('*'));


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
