package com.mcs;

import com.mcs.interfaces.InfixPreFixPostFix;
import com.mcs.services.InfixToPostFix;
import com.mcs.services.InfixToPrefix;
import com.mcs.services.MyStack;

import java.util.Scanner;

public class InfixConvertRunner {
    public static void main(String[] args) {

//        1.  Infix to Post fix notation Algorithm and implement it in java using your own linked list stack class.
//        Try different examples.

        System.out.println("Please enter your infix convert to prefix.");
        Scanner scanner=new Scanner(System.in);
        String infix = scanner.nextLine();
        infix=infix.replaceAll("\\s", "");
        System.out.println("\nInput infix received = " + infix);

        InfixPreFixPostFix toPrefix=new InfixToPrefix(new MyStack<>(), new MyStack<>(), infix );
        toPrefix.convertInfixTo();

//        2.  Infix to Prefix notation Algorithm and implement it in java using your own linked list stack class. Try
//        different examples

        System.out.println("\nInput infix received = " + infix);
        InfixPreFixPostFix toPostFix=new InfixToPostFix(new MyStack<>(), new MyStack<>(), infix);
        toPostFix.convertInfixTo();
    }
}
