/**   
 * @Title: Test.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月10日 下午10:31:26    
 * @version V1.0   
 */
package com.jiuwei.plugins.event;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.IPlugin;
import com.jiuwei.plugins.event.entity.TestEvent;

/**
 * @author cpthack
 * 
 */
public class EventTest {

	/**
	 * @Description TODO
	 * @example TODO
	 * @param args
	 * @author cpthack
	 * @date 2016年10月10日 下午10:31:26
	 * @name com.jiuwei.backstage.base.event.Test.main
	 */
	public static void main(String[] args) {
		IPlugin plugin = new EventPlugin();
		plugin.start();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "15816825241");
		EventKit.post(new TestEvent(params));

	}

}
