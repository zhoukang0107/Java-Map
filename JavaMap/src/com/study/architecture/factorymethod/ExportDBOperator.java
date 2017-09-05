package com.study.architecture.factorymethod;

/**
 * 导出数据库文件
 * Created by Zack on 2017/5/29.
 */
public class ExportDBOperator extends ExportOperate{
   /* public void export(String data){
        //导出数据后还可以做一些其他操作
        ExportDBFile file = new ExportDBFile();
        file.export(data);
    }*/

    @Override
    protected ExportFileApi newFileApi() {
        return new ExportDBFile();
    }
}
