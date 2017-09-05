package com.study.architecture.interpreter;

public class Caculator {
    public int build(String statement){
        Node left = null;
        Node right = null;
        Node lastNode = null;
        String[] statements = statement.split(" ");
        for (int i=0;i<statements.length;i++){
            if ("*".equals(statements[i])){
                //计算乘法
                left = lastNode;
                int val = Integer.valueOf(statements[++i]);
                //新建一个终结符
                right = new ValueNode(val);
                //新建一个非终结符
                lastNode = new MulNode(left,right);
            }else if ("/".equals(statements[i])){
                //计算除法
                left = lastNode;
                int val = Integer.valueOf(statements[++i]);
                right = new ValueNode(val);
                lastNode = new DivNode(left,right);
            }else{
                lastNode = new ValueNode(Integer.valueOf(statements[i]));
            }
        }
        return  lastNode.interpret();
    }
}
