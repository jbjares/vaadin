package com.vaadin.demo.dashboard.view.dashboard;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vaadin.risto.formsender.FormSender;
import org.vaadin.risto.formsender.widgetset.client.shared.Method;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

import eu.insight.nhsdashboard.server.HelloBean;
import eu.insight.nhsdashboard.server.SpringBeanFactory;

/**
 * Simple name editor Window.
 */
public class DashboardRestCallExample extends Window {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6617276612560288469L;

	
    private final DashboardRestCallExampleListener listener;

    public DashboardRestCallExample(final DashboardRestCallExampleListener listener,
            final String currentName) throws IOException {
        this.listener = listener;
        setCaption("DashboardRestCallExample");
        setModal(true);
        setClosable(true);
        setResizable(false);
        setWidth(600.0f, Unit.PIXELS);
        setHeight(600.0f, Unit.PIXELS);
        addStyleName("edit-dashboard");

        setContent(buildContent(currentName));
    }

    private Component buildContent(final String currentName) throws IOException {
        VerticalLayout result = new VerticalLayout();
        result.setMargin(true);
        result.setSpacing(true);
        HelloBean bean = SpringBeanFactory.create(HelloBean.class);
        TextArea ta = new TextArea();
        ta.setValue(bean.getMessage());
        result.addComponent(ta);
        return result;
    }


    public interface DashboardRestCallExampleListener {
        void dashboardNameEdited(String name);
    }
}
