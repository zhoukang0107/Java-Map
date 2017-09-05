package com.study.architecture.interpreter;

public class InterpreterClient {

    public static void main(String[] args){

        String contentString = "3 * 5 * 7 / 3";
        Caculator caculator = new Caculator();
        int result = caculator.build(contentString);
        System.out.println(result);
    }
}
