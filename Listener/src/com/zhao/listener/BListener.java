package com.zhao.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class BListener
 *
 */
@WebListener
public class BListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scab) {
        System.out.println("");
    }

	
    public void attributeRemoved(ServletContextAttributeEvent scab) {
       
    }


    public void attributeReplaced(ServletContextAttributeEvent scab) {
       
    }
	
}
