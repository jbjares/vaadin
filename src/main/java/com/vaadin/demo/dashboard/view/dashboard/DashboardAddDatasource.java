package com.vaadin.demo.dashboard.view.dashboard;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Simple name editor Window.
 */
@SuppressWarnings("serial")
public class DashboardAddDatasource extends Window {

    private final DashboardAddDatasourceListener listener;

    public DashboardAddDatasource(final DashboardAddDatasourceListener listener,
            final String currentName) {
        this.listener = listener;
        setCaption("Add Datasource");
        setModal(true);
        setClosable(true);
        setResizable(false);
        setWidth(600.0f, Unit.PIXELS);
        setHeight(600.0f, Unit.PIXELS);
        addStyleName("edit-dashboard");

        setContent(buildContent(currentName));
    }

    private Component buildContent(final String currentName) {
        VerticalLayout result = new VerticalLayout();
        result.setMargin(true);
        result.setSpacing(true);

		BrowserFrame shinyAppFileUpload = new BrowserFrame("",
		new ExternalResource("http://127.0.0.1:9876/?cmd=fileUpload"));
		shinyAppFileUpload.addStyleName(ValoTheme.LABEL_H1);
		shinyAppFileUpload.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		shinyAppFileUpload.setHeight("400");
		shinyAppFileUpload.setWidth("400");
		result.addComponent(shinyAppFileUpload);

        return result;
    }


    public interface DashboardAddDatasourceListener {
        void dashboardNameEdited(String name);
    }
}
