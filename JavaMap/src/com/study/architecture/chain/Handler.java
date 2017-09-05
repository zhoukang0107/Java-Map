package com.study.architecture.chain;

/**
 * 抽象处理类
 *
 *
 *
 */
public abstract class Handler {
    public Handler nextHandler;  //下一个对象的引用


    public void handRequest(AbstractRequest request){
        if (request.getRequestLevel()==getHandlerLevel()){
            handler(request);
        }else{
            if (nextHandler!=null){
                nextHandler.handRequest(request);
            }else{
                System.out.println("---->所有处理对象都不能处理");
            }
        }
    }

    /**
     * 具体的处理方法让子类去实现
     * @param request
     */
    public abstract void handler(AbstractRequest request);

    /**
     * 返回能够处理请求的级别
     * @return
     */
    public abstract int getHandlerLevel();

}
