/**   
 * @Title: ApplicationEventMulticaster.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月9日 下午10:39:34    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;


/**
 * @author cpthack
 * 
 */
public interface ApplicationEventMulticaster {

	void addApplicationListener(Class<?> clazz2);

	void removeApplicationListener(ListenerHelper listener);

	void removeAllListeners();

	void multicastEvent(ApplicationEvent event);

}
