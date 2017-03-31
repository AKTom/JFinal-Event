/**   
 * @Title: TestEvent.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月11日 上午12:01:25    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.entity;

import com.jiuwei.plugins.event.core.ApplicationEvent;

/**
 * @author cpthack
 *
 */
public class TestEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 558377470489439884L;

	/**
	 * @param source
	 */
	public TestEvent(Object source) {
		super(source);
	}

}
