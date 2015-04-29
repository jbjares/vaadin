package eu.insight.nhsdashboard.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.CaseFormat;

public class SpringBeanFactory {
	
	
	  public static <T> T create(Class<T> type) {
		  
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String className = type.getSimpleName();
        className = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,className);
        T bean = (T) context.getBean(className);
		  
       return (T)bean;
	  }

}
