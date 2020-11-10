package com.mcs.services;

import com.mcs.interfaces.InfixPreFixPostFix;

import java.util.Arrays;

public class InfixToPrefix implements InfixPreFixPostFix {

    private MyStack<Character> operatorStack;
    private MyStack<Character> resultStack;
    private String infixStr;
    private char[] infixArr;
    private char infixChar;


    public InfixToPrefix(MyStack<Character> operatorStack, MyStack<Character> resultStock, String infixStr) {
        this.operatorStack = operatorStack;
        this.resultStack = resultStock;
        this.infixStr=infixStr;
        this.infixArr = infixStr.toCharArray();
    }

    @Override
    public boolean isCharOperator(char charIn) {
        return "^*/+-".contains(String.valueOf(charIn));
    }

    @Override
    public boolean isBracket(char charIn) {
        return "{[(}])".contains(String.valueOf(charIn));
    }

    @Override
    public int getOperatorPriority(char charIn) {
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

    @Override
    public void convertInfixTo() {
        for(int index = infixArr.length-1; index>=0; index--){
            infixChar=infixArr[index];
            if(isCharOperator(infixArr[index])){
                matrixIfCharOperator();
            }else if (isBracket(infixArr[index])){
                matrixIfCharBrackets();

            }else {
                resultStack.push(infixArr[index]);

            }

        }
        while(!operatorStack.isEmpty()){
            resultStack.push(operatorStack.pop());
        }

        System.out.println("result stack in Array = bottom <- "+ Arrays.toString(resultStack.toArray())+" <- top");
        System.out.println("Infix = ["+infixStr+"] to prefix = ["+resultStack.getPrefixString()+"]");

    }

    @Override
    public void matrixIfCharOperator() {
        if (!operatorStack.isEmpty()) {
            if (getOperatorPriority(operatorStack.getTop()) > getOperatorPriority(infixChar)) {
                resultStack.push(operatorStack.pop());
            }
        }
        operatorStack.push(infixChar);
    }

    @Override
    public void matrixIfCharBrackets() {
        if(infixChar==')'){
            operatorStack.push(infixChar);
        }else if(infixChar=='('){
            while(operatorStack.getTop()!=')'){
                if(!isBracket(operatorStack.getTop()))
                    resultStack.push(operatorStack.pop());
                else
                    operatorStack.pop();
            }
            operatorStack.pop();
        }
    }


}
