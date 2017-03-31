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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.jiuwei.plugins.event.annotation.Listener;
import com.jiuwei.plugins.event.utils.ClassHelper;

/**
 * @author cpthack
 * 
 */
public abstract class AbstractApplicationEventMulticaster implements
		ApplicationEventMulticaster {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private ArrayListMultimap<Type, ListenerHelper> listeners;

	protected void setListeners(
			ArrayListMultimap<Type, ListenerHelper> listeners) {
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
	public void addApplicationListener(Class<?> clazz2) {
		Class<? extends ApplicationListener> clazz = (Class<? extends ApplicationListener>) clazz2;
		Type type = ((ParameterizedType) clazz.getGenericInterfaces()[0])
				.getActualTypeArguments()[0];

		Listener annotation = clazz.getAnnotation(Listener.class);

		boolean enableAsync = annotation == null ? false : annotation
				.enableAsync();
		int order = annotation == null ? Integer.MAX_VALUE : annotation.order();

		ApplicationListener listener = ClassHelper.newInstance(clazz);

		if (listeners == null) {
			listeners = ArrayListMultimap.create();
		}

		listeners.put(type, new ListenerHelper(listener, enableAsync, order));
		logger.debug("add>>tppe=" + type + ">>>listener=" + listener.getClass());
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
		logger.debug("getApplicationListeners>>>type=" + type);
		Map<Integer,ListenerHelper> listenerHelperMap = new TreeMap<Integer,ListenerHelper>();
		for(ListenerHelper listenerHelper:listeners.get(type)){
			listenerHelperMap.put(listenerHelper.getOrder(),listenerHelper);
		}
		return listenerHelperMap.values();
	}

}
