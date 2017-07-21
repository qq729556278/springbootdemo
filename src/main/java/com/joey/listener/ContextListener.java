package com.joey.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by aijiao on 2016/7/27.
 */
public class ContextListener implements ApplicationListener {
    private Logger logger = Logger.getLogger(ContextListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info(event.getClass().toString());
    }
}
