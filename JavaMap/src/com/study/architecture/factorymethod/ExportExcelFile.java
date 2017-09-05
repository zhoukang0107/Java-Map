package com.study.architecture.factorymethod;

public class ExportExcelFile implements ExportFileApi {
    @Override
    public void export(String data) {
        System.out.println("导出excel数据");
    }
}
