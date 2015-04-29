package com.vaadin.demo.dashboard.component;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.vaadin.annotations.JavaScript;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

@JavaScript({ 
	  "http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js",
	  "http://timeago.yarp.com/jquery.timeago.js"
	})
public class TimeAgoLabel extends Label{
	private static final long serialVersionUID = 4407554186213112809L;

	public static final String JQUERY_TIMEAGO_SCRIPT = "jQuery('time.timeago').timeago();";

	  static DateTimeFormatter isoFormatter = ISODateTimeFormat.dateTime();
	  static DateTimeFormatter localFormatter = DateTimeFormat.forPattern("dd.MM.yyyy hh:mm");

	  public TimeAgoLabel(DateTime datetime) {
	    String iso = isoFormatter.print(datetime);
	    String loc = localFormatter.print(datetime);
	    setValue(String.format("<time class='timeago' datetime='%s'>%s</time>", iso, loc));
	    setContentMode(ContentMode.HTML);
	  }

}
