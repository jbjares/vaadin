package com.vaadin.demo.dashboard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import org.springframework.web.context.ContextLoaderListener;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.spring.server.SpringVaadinServlet;



@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = DashboardUI.class, widgetset = "com.vaadin.demo.dashboard.DashboardWidgetSet.gwt.xml")
@SuppressWarnings("serial")
public class DashboardServlet extends SpringVaadinServlet {
	


    @Override
    protected final void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new DashboardSessionInitListener());
    }
}