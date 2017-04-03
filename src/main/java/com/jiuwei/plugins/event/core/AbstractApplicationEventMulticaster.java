/**   
 * @Title: AbstractApplicationEventMulticaster.java    
 * @Package com.jiuwei.backstage.base.event    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月10日 上午1:22:59    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuwei.plugins.event.annotation.Listener;
import com.jiuwei.plugins.event.utils.ClassHelper;

/**
 * @author cpthack
 * 
 */
public abstract class AbstractApplicationEventMulticaster implements
		ApplicationEventMulticaster {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static Map<Type, Map<String,ListenerHelper>> listeners;

	@SuppressWarnings("static-access")
	protected void setListeners(
			Map<Type, Map<String,ListenerHelper>> listeners) {
		this.listeners = listeners;
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @param clazz2
	 * @author cpthack
	 * @date 2016年10月10日 上午1:22:59
	 * @name 
	 *       com.jiuwei.backstage.base.event.AbstractApplicationEventMulticaster.
	 *       addApplicationListener
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public synchronized void addApplicationListener(Class<?> clazz2) {
		Class<? extends ApplicationListener> clazz = (Class<? extends ApplicationListener>) clazz2;
		Type type = ((ParameterizedType) clazz.getGenericInterfaces()[0])
				.getActualTypeArguments()[0];

		Listener annotation = clazz.getAnnotation(Listener.class);

		boolean enableAsync = annotation == null ? false : annotation
				.enableAsync();
		int order = annotation == null ? Integer.MAX_VALUE : annotation.order();

		ApplicationListener listener = ClassHelper.newInstance(clazz);

		if (listeners == null) {
			listeners = new ConcurrentHashMap<Type, Map<String,ListenerHelper>>();
		}
		
		Map<String,ListenerHelper> listenerHelperMap = listeners.get(type);
		if(listenerHelperMap==null){
			listenerHelperMap = new TreeMap<String,ListenerHelper>();
		}
		
		String listenerHelperMapKey=order+""+listener.getClass().getName();
		System.out.println(listenerHelperMapKey);
		if(!listenerHelperMap.containsKey(listenerHelperMapKey)){
			listenerHelperMap.put(listenerHelperMapKey, new ListenerHelper(listener, enableAsync, order));
			logger.debug("Add Type=" + type + ", The Listener is " + listener.getClass());
		}
		else{
			logger.warn("Find Type="+type+" Add Repeat!");
		}
		
		listeners.put(type,listenerHelperMap);
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @param listener
	 * @author cpthack
	 * @date 2016年10月10日 上午1:22:59
	 * @name 
	 *       com.jiuwei.backstage.base.event.AbstractApplicationEventMulticaster.
	 *       removeApplicationListener
	 */
	@Override
	public void removeApplicationListener(ListenerHelper listener) {
		System.out.println("it's no finishes.");
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @author cpthack
	 * @date 2016年10月10日 上午1:22:59
	 * @name 
	 *       com.jiuwei.backstage.base.event.AbstractApplicationEventMulticaster.
	 *       removeAllListeners
	 */
	@Override
	public void removeAllListeners() {
		listeners.isEmpty();
	}

	/**
	 * @Description TODO
	 * @example TODO
	 * @return
	 * @author cpthack
	 * @param <T>
	 * @date 2016年10月12日 上午1:25:49
	 * @name 
	 *       com.jiuwei.backstage.base.event.AbstractApplicationEventMulticaster.
	 *       getApplicationListeners
	 */
	public Collection<ListenerHelper> getApplicationListeners(ApplicationEvent event) {
		Type type = event.getClass();
		logger.debug("GetApplicationListeners By Type is" + type);
		return listeners.get(type).values();
	}

}
