/**   
 * @Title: ClassHelper.java    
 * @Package com.jiuwei.backstage.base.event.utils    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月12日 下午8:56:09    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.utils;

/**
 * @author cpthack
 * 
 */
public class ClassHelper {
	
	public static <T> T newInstance(Class<?> clazz) {
		try {
			return (T) clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
