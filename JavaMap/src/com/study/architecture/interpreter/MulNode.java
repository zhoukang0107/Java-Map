package com.study.architecture.interpreter;

/**
 * 运算乘法
 */
public class MulNode extends SymbolNode {
    public MulNode(Node left, Node right) {
        super(left, right);
    }

    /**
     * 计算：乘法
     * @return
     */
    @Override
    public int interpret() {
        return left.interpret()*right.interpret();
    }
}
