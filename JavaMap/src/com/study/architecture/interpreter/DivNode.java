package com.study.architecture.interpreter;

public class DivNode extends SymbolNode{
    public DivNode(Node left, Node right) {
        super(left, right);
    }

    /**
     * 计算：除法
     * @return
     */
    @Override
    public int interpret() {
        return left.interpret()/right.interpret();
    }
}
