/**   
 * @Title: EventPlugin.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月11日 上午2:43:24    
 * @version V1.0   
 */
package com.jiuwei.plugins.event;

import java.util.Set;

import com.jfinal.plugin.IPlugin;
import com.jiuwei.plugins.event.core.AbstractApplicationEventMulticaster;
import com.jiuwei.plugins.event.core.ApplicationListener;
import com.jiuwei.plugins.event.core.SimpleApplicationEventMulticaster;
import com.jiuwei.plugins.event.utils.ClassUtil;

/**
 * @author cpthack
 * 
 */
public class EventPlugin implements IPlugin {

	private String scanPackage = "com";

	public EventPlugin() {};

	public EventPlugin(String scanPackage) {
		this.scanPackage = scanPackage;
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @return
	 * @author cpthack
	 * @date 2016年10月11日 上午2:43:24
	 * @name com.jiuwei.backstage.base.event.EventPlugin.start
	 */
	@Override
	public boolean start() {
		Set<Class<?>> clazzSet = ClassUtil.scanPackageBySuper(scanPackage,
				true, ApplicationListener.class);
		AbstractApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();

		for (Class<?> clazz : clazzSet) {

			applicationEventMulticaster.addApplicationListener(clazz);
		}

		EventKit eventKit = new EventKit();
		eventKit.setApplicationEventMulticaster(applicationEventMulticaster);

		return true;
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @return
	 * @author cpthack
	 * @date 2016年10月11日 上午2:43:24
	 * @name com.jiuwei.backstage.base.event.EventPlugin.stop
	 */
	@Override
	public boolean stop() {
		System.out.println("the application is stoped.");
		return true;
	}

}
