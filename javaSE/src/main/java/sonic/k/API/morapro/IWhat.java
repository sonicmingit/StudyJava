package sonic.k.API.morapro;

/**
 * 出拳的接口,有出拳的方法,获取名称和结果的方法
 * 
 * @author 郝一鸣
 *
 */
public interface IWhat {
	/**
	 * 出拳的方法 返回出拳结果:1.剪刀;2.石头.3.布
	 * 
	 * @return 出拳结果
	 */
	int WhatOut();

	// 获取名称的方法
	String getName();

	// 获取结果的方法
	int getOut();
}
