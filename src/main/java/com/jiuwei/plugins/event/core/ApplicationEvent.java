/**   
 * @Title: ApplicationEvent.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月9日 下午7:58:41    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

import java.util.EventObject;

/**
 * @author cpthack
 * 
 */
public abstract class ApplicationEvent extends EventObject {
	private static final long serialVersionUID = -2803399617615254976L;
	private final long timestamp;

	/**
	 * @param source
	 */
	public ApplicationEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}

	public final long getTimestamp() {
		return this.timestamp;
	}
}
