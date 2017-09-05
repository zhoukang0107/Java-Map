package com.study.architecture.factorymethod;

public class ExportExcelOperator extends ExportOperate {
    @Override
    protected ExportFileApi newFileApi() {
        return new ExportExcelFile();
    }
}
