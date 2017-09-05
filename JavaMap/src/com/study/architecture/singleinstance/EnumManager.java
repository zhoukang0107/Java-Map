package com.study.architecture.singleinstance;

/**
 * 解决反序列化，产生多个示例
 */
public enum EnumManager {
    SDCardManager(10){
        public EnumManager getSingle(){
            return SDCardManager;
        }
    },
    HttpManager(1){
        public EnumManager getSingle(){
            return null;
        }
    };
    public SdCardImpl getSingleton(){
        return new SdCardImpl();
    }

    public abstract EnumManager getSingle();
    private EnumManager(int type){

    }
}
