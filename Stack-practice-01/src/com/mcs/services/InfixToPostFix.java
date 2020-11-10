package com.mcs.services;

import com.mcs.interfaces.InfixPreFixPostFix;

public class InfixToPostFix implements InfixPreFixPostFix {
    private MyStack<Character> operatorStack;
    private MyStack<Character> resultStack;
    private String infixStr;
    private char[] infixArr;
    private char infixChar;

    public InfixToPostFix(MyStack<Character> operatorStack, MyStack<Character> resultStock, String infixStr) {
        this.operatorStack = operatorStack;
        this.resultStack = resultStock;
        this.infixStr=infixStr;
        this.infixArr = infixStr.toCharArray();
    }

    @Override
    public boolean isCharOperator(char charIn) {
        return false;
    }

    @Override
    public boolean isBracket(char charIn) {
        return false;
    }

    @Override
    public int getOperatorPriority(char charIn) {
        return 0;
    }

    @Override
    public void convertInfixTo() {

    }

    @Override
    public void matrixIfCharOperator() {

    }

    @Override
    public void matrixIfCharBrackets() {

    }
}
