/**   
 * @Title: ListenerHepler.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月12日 下午1:36:47    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

/**
 * @author cpthack
 * 
 */
class ListenerHelper {

	@SuppressWarnings("rawtypes")
	private final ApplicationListener listener;

	private final boolean enableAsync;

	private final int order;

	@SuppressWarnings("rawtypes")
	public ListenerHelper(ApplicationListener listener, boolean enableAsync,
			int order) {
		this.listener = listener;
		this.enableAsync = enableAsync;
		this.order = order;
	}

	@SuppressWarnings("rawtypes")
	public ApplicationListener getListener() {
		return listener;
	}

	public boolean isEnableAsync() {
		return enableAsync;
	}

	public int getOrder() {
		return order;
	}

}
