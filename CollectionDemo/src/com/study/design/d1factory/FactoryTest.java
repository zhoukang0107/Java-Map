package com.study.design.d1factory;
/**
 * 简单工厂：提供创建对象的功能不需要关心具体的实现
 * 好处：降低客户端（调用方）与模块之间的耦合度（最少知识原则）
 * 场景：创建对象
 * 一般SDK/Framework/第三方库编写者通过工厂方法提供给调用者使用，
 * 让调用方法的人不需要知道要创建对象内部具体实现，就可以快速实现想要的对象
 * 
 * （将类定义为非public可以防止别人使用此类）
 *
 */
public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Api aip = new ApiImpl();
	}

}
