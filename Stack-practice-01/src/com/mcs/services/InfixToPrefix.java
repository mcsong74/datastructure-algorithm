package com.mcs.services;

import com.mcs.MyStack;
import com.mcs.interfaces.InfixPreFixPostFix;

public class InfixToPrefix implements InfixPreFixPostFix {

    private MyStack<Character> operatorStack;
    private MyStack<Character> resultStack;
    private char[] infixArr;

    public InfixToPrefix(MyStack<Character> operatorStack, MyStack<Character> resultStock, char[] infixArr) {
        this.operatorStack = operatorStack;
        this.resultStack = resultStock;
        this.infixArr = infixArr;
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
    public void convertInfixToPrefix(){
        for(int rIndex = infixArr.length-1; rIndex>=0; rIndex--){
            if(isCharOperator(infixArr[rIndex])){
                matrixIfCharOperator(operatorStack, resultStack, infixArr[rIndex]);
            }else if (isBracket(infixArr[rIndex])){
                matrixIfCharBrackets(operatorStack, resultStack, infixArr[rIndex]);

            }else {
                resultStack.push(infixArr[rIndex]);

            }

        }
        while(!operatorStack.isEmpty()){
            resultStack.push(operatorStack.pop());
        }
    }
    public void matrixIfCharOperator(MyStack<Character> operatorStack, MyStack<Character> resultStack, char charIn){
        if (!operatorStack.isEmpty()) {
            if (getOperatorPriority(operatorStack.getTop()) > getOperatorPriority(charIn)) {
                resultStack.push(operatorStack.pop());
            }
        }
        operatorStack.push(charIn);
    }
    public void matrixIfCharBrackets(MyStack<Character> operatorStack, MyStack<Character> resultStack,
                                            char charIn){
        if(charIn==')'){
            operatorStack.push(charIn);
        }else if(charIn=='('){
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
