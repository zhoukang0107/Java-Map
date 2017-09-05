package com.study.architecture.interpreter;

/**
 * 终结符
 */
public class ValueNode implements Node {
    private int value;

    public ValueNode(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}
