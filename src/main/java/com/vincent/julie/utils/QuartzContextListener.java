
package com.vincent.julie.utils;

import org.quartz.impl.StdScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Title: QuartzContextListener.java
 * @Package com.vincent.julie.utils
 * @Description: QuartzContextListener
 * @author Vincent
 * @version V1.0
 */
public class QuartzContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzContextListener.class);

	/*
	 * @seejavax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		WebApplicationContext webApplicationContext = (WebApplicationContext) arg0.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		if (webApplicationContext == null) {
			LOGGER.error("webApplicationContext is null");
			return;
		}
		StdScheduler startQuertz = (StdScheduler) webApplicationContext.getBean("startQuertz");
		if (startQuertz != null) {
			startQuertz.shutdown();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	}
}
