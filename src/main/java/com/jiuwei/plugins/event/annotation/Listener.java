/**   
 * @Title: Listener.java    
 * @Package com.jiuwei.backstage.base.event.annotation    
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author cpthack cpt@jianzhimao.com 
 * @date 2016年10月12日 下午1:40:36    
 * @version V1.0   
 */
package com.jiuwei.plugins.event.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cpthack
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Listener {

	int order() default Integer.MAX_VALUE;// 事件执行顺序

	boolean enableAsync() default false;// 表示事件是否异步执行

}
