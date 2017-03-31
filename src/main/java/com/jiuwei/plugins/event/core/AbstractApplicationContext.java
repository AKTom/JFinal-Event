/**   
 * @Title: AbstractApplicationContext.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月10日 上午1:04:31    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

/**
 * @author cpthack
 * 
 */
public abstract class AbstractApplicationContext implements
		ApplicationEventPublisher {
	private ApplicationEventMulticaster applicationEventMulticaster;

	protected void setApplicationEventMulticaster(
			ApplicationEventMulticaster applicationEventMulticaster) {
		this.applicationEventMulticaster = applicationEventMulticaster;
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @param event
	 * @author cpthack
	 * @date 2016年10月10日 上午1:04:32
	 * @name 
	 *       com.jiuwei.backstage.base.event.AbstractApplicationContext.publishEvent
	 */
	@Override
	public void publishEvent(ApplicationEvent event) {
		getApplicationEventMulticaster().multicastEvent(event);
	}

	private ApplicationEventMulticaster getApplicationEventMulticaster()
			throws IllegalStateException {
		if (this.applicationEventMulticaster == null) {
			throw new IllegalStateException(
					"ApplicationEventMulticaster not initialized - "
							+ "call 'refresh' before multicasting events via the context: "
							+ this);
		}
		return this.applicationEventMulticaster;
	}
}
