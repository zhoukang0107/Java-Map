package com.study.architecture.factorymethod;

/**
 * Created by Zack on 2017/5/29.
 */
public class ExportTextOperate extends ExportOperate{

    @Override
    protected ExportFileApi newFileApi() {
        return new ExportTextFile();
    }
}
