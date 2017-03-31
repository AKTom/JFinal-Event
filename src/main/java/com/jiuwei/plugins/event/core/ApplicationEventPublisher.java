/**   
 * @Title: ApplicationEventPublisher.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月9日 下午10:39:07    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

/**
 * @author cpthack
 * 
 */
public interface ApplicationEventPublisher {

	void publishEvent(ApplicationEvent event);

}
