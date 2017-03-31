/**   
 * @Title: SimpleApplicationContext.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月12日 上午1:14:12    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

/**
 * @author cpthack
 * 
 */
public class SimpleApplicationContext extends AbstractApplicationContext {
	
	@Override
	public void setApplicationEventMulticaster(
			ApplicationEventMulticaster applicationEventMulticaster) {
		super.setApplicationEventMulticaster(applicationEventMulticaster);
	}

}
