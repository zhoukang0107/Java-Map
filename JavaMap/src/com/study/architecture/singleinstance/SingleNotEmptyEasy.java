package com.study.architecture.singleinstance;

/**
 * 多线程安全
 * 随用随加载,效率不高
 *
 * synchronized:同步
 */
public class SingleNotEmptyEasy {
    private static SingleNotEmptyEasy singleNotEmptyEasy = null;
    public static synchronized SingleNotEmptyEasy getInstance(){
        if (singleNotEmptyEasy==null){
            singleNotEmptyEasy = new SingleNotEmptyEasy();
        }
        return singleNotEmptyEasy;
    }
}
