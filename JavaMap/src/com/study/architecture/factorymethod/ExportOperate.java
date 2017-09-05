package com.study.architecture.factorymethod;

/**
 *
 * Created by Zack on 2017/5/29.
 */
public abstract class ExportOperate {
    /**
     * 导出数据   提取公共部分由父类去实现，具体的创建实现由父类完成
     * @param data
     */
    public void export(String data){
        ExportFileApi file = newFileApi();
        file.export(data);
    }

    /**
     * 实例化exportApi
     * @return
     */
    protected abstract ExportFileApi newFileApi();
}
