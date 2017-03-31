/**   
 * @Title: ApplicationListener.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月9日 下午8:02:22    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

import java.util.EventListener;

/**
 * @author cpthack
 * 
 */
public interface ApplicationListener<E extends ApplicationEvent> extends
		EventListener {
	
	void onApplicationEvent(E event);
}
