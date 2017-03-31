/**   
 * @Title: TestApplicationListener.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月10日 下午10:33:36    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.listener;

import java.util.Map;

import com.jiuwei.plugins.event.annotation.Listener;
import com.jiuwei.plugins.event.core.ApplicationListener;
import com.jiuwei.plugins.event.entity.TestEvent;

/**
 * @author cpthack
 * @param <E>
 * 
 */
@Listener(enableAsync=false)
public class TestApplicationListener implements
		ApplicationListener<TestEvent> {

	/**
	 * @Description TODO
	 * @example TODO
	 * @param event
	 * @author cpthack
	 * @date 2016年10月11日 上午12:02:19
	 * @name com.jiuwei.backstage.base.event.ApplicationListener<TestEvent>.onApplicationEvent
	 */
	@Override
	public void onApplicationEvent(TestEvent event) {
		System.out.println("监听到事件，我应该做点什么呢？");
		Map<String, Object> paramsMap=(Map<String, Object>) event.getSource();
		System.out.println("收到的信息有:"+paramsMap.get("phone"));
	}

}
