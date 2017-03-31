/**   
 * @Title: EventKit.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月9日 上午12:55:21    
 * @version V1.0   
 */
package com.jiuwei.plugins.event;

import com.jiuwei.plugins.event.core.ApplicationEvent;
import com.jiuwei.plugins.event.core.ApplicationEventMulticaster;
import com.jiuwei.plugins.event.core.SimpleApplicationContext;

/**
 * @author cpthack
 * 
 */
public class EventKit {
	private final static SimpleApplicationContext applicationContext = new SimpleApplicationContext();

	public void setApplicationEventMulticaster(
			ApplicationEventMulticaster applicationEventMulticaster) {
		applicationContext
				.setApplicationEventMulticaster(applicationEventMulticaster);
	}

	public static void post(ApplicationEvent event) {
		applicationContext.publishEvent(event);
	}
}
