package com.jxau.bank.factory;

import java.util.ResourceBundle;

/**
 * 1、读取配置文件 2、根据配置文件的信息生成对应的对象
 *
 * @author Administrator
 *
 */
public class UserDaoFactory {

	public static ResourceBundle bundle;
	static {
		// 默认获取src资源文件，xxx.properties
		// 根据文件名获取
		bundle = ResourceBundle.getBundle("classInfo");
	}
	/**
	 * 构造任意类型的对象 * @param key
	 *
	 * @param classType
	 * @return
	 * @throws ClassNotFoundException
	 */

	public static <T> T getInstance(String key, Class<T> classType)
			throws ClassNotFoundException {
		// 根据Key获取values
		String className = bundle.getString(key);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}


