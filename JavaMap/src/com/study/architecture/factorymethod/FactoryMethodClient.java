package com.study.architecture.factorymethod;

/**
 * 修改关闭原则
 *
 * 产品：
 * ExportApi:ExportExcelApi,ExportDBApi,ExportTextApi
 * 创建者(工厂):
 * ExportOperator:ExportDBOperator,ExportExcelOperatr...
 *
 * 将对象的实现延迟到子类中去实现
 *
 * Created by Zack on 2017/5/29.
 */
public class FactoryMethodClient {
    public static void  main(String[] args){
        String data = "我的数据";
        ExportDBOperator operator = new ExportDBOperator();
        operator.export(data);

        ExportExcelOperator excelOperator = new ExportExcelOperator();
        excelOperator.export(data);
    }
}
