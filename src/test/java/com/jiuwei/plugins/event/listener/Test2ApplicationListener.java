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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuwei.plugins.event.annotation.Listener;
import com.jiuwei.plugins.event.core.ApplicationListener;
import com.jiuwei.plugins.event.entity.TestEvent;

/**
 * @author cpthack
 * @param <E>
 * 
 */
@Listener(enableAsync = false,order=5)
public class Test2ApplicationListener implements ApplicationListener<TestEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @Description TODO
	 * @example TODO
	 * @param event
	 * @author cpthack
	 * @date 2016年10月11日 上午12:02:19
	 * @name com.jiuwei.backstage.base.event.ApplicationListener<TestEvent>.
	 *       onApplicationEvent
	 */
	@Override
	public void onApplicationEvent(TestEvent event) {
		logger.debug("我是【" + event.getClass() + "】的事件监听器-2>>>"
				+ this.getClass());
		logger.debug("监听到事件，我应该做点什么呢？");
		Map<String, Object> paramsMap = (Map<String, Object>) event.getSource();
		logger.debug("收到的信息有:" + paramsMap.get("phone"));
	}

}
