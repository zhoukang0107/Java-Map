package com.study.architecture.factorymethod;

/**
 * Created by Zack on 2017/5/29.
 */
public class ExportTextFile implements ExportFileApi {
    @Override
    public void export(String data) {
        System.out.println("导出数据到文本文件");
    }
}
