package com.mcs.interfaces;

import com.mcs.MyStack;

public interface InfixPreFixPostFix {


    boolean isCharOperator(char charIn);
    boolean isBracket(char charIn);
    int getOperatorPriority(char charIn);


}
