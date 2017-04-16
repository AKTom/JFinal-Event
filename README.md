# JFinal-Event

模拟spring事件驱动核心包spring-event的功能，基于JFinal框架开发的事件驱动插件，使用非常简单。

## 一、使用示例：

#### 1、首先定义一个事件
> TestEvent.java代码引用

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
	
创建一个事件类并继承ApplicationEvent类.

配置样例如：[TestEvent.java](https://github.com/cpthack/JFinal-Event/blob/master/src/test/java/com/jiuwei/plugins/event/entity/TestEvent.java)所示

#### 2、创建事件监听器

##### （1）创建TestEvent.java类的监听器1：Test1ApplicationListener.java
> Test1ApplicationListener.java代码引用

		@Listener(enableAsync = false,order=3)
		public class Test1ApplicationListener implements ApplicationListener<TestEvent> {
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
				logger.debug("我是【" + event.getClass() + "】的事件监听器-1>>>"
						+ this.getClass());
				logger.debug("监听到事件，我应该做点什么呢？");
				Map<String, Object> paramsMap = (Map<String, Object>) event.getSource();
				logger.debug("收到的信息有:" + paramsMap.get("phone"));
				}
	
		}
		
##### （2）创建TestEvent.java类的监听器2：Test2ApplicationListener.java
> Test2ApplicationListener.java代码引用

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

创建一个监听类并继承ApplicationListener<TestEvent>类.

配置样例如：[Test2ApplicationListener.java](https://github.com/cpthack/JFinal-Event/blob/master/src/test/java/com/jiuwei/plugins/event/listener/Test2ApplicationListener.java)所示


#### 3、事件发送/监听测试类
> EventTest.java代码引用

		IPlugin plugin = new EventPlugin().setScanPackage("com.jiuwei");
		plugin.start();
		plugin.start();
		plugin.start();
		plugin.start();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", "15816825241");
		EventKit.post(new TestEvent(params));


## 二、具体参考：

* 自定义事件-参考类：[TestEvent.java](https://github.com/cpthack/JFinal-Event/blob/master/src/test/java/com/jiuwei/plugins/event/entity/TestEvent.java)

* 自定义监听器-参考类：[Test1ApplicationListener.java](https://github.com/cpthack/JFinal-Event/blob/master/src/test/java/com/jiuwei/plugins/event/listener/Test1ApplicationListener.java)

* 事件/发送测试类：[EventTest.java](https://github.com/cpthack/JFinal-Event/blob/master/src/test/java/com/jiuwei/plugins/event/EventTest.java)
