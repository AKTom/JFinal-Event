/**   
 * @Title: SimpleApplicationEventMulticaster.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月12日 上午1:20:21    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

import java.util.concurrent.Executor;

import org.apache.log4j.Logger;

/**
 * @author cpthack
 * 
 */
public class SimpleApplicationEventMulticaster extends
		AbstractApplicationEventMulticaster {
	private final Logger logger = Logger.getLogger(this.getClass());
	private Executor taskExecutor;

	public void setTaskExecutor(Executor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	protected Executor getTaskExecutor() {
		return this.taskExecutor;
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @param event
	 * @author cpthack
	 * @date 2016年10月12日 上午1:20:21
	 * @name com.jiuwei.backstage.base.event.SimpleApplicationEventMulticaster.
	 *       multicastEvent
	 */
	@Override
	public void multicastEvent(final ApplicationEvent event) {
		Executor executor = getTaskExecutor();
		for (final ListenerHelper listener : getApplicationListeners(event)) {
			logger.debug("Doing ApplicationListener >>>" + listener.getListener().getClass());
			if (listener.isEnableAsync()) {// 异步执行
				if (executor != null) {
					executor.execute(new Runnable() {
						public void run() {
							listener.getListener().onApplicationEvent(event);
						}
					});
				}
				continue;
			}
			// 无需异步执行
			listener.getListener().onApplicationEvent(event);
		}
	}

}
