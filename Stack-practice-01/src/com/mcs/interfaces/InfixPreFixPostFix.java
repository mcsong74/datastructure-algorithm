package com.mcs.interfaces;

public interface InfixPreFixPostFix {
    boolean isCharOperator(char charIn);
    boolean isBracket(char charIn);
    int getOperatorPriority(char charIn);
}
