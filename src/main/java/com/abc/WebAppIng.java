package com.abc;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppIng implements WebApplicationInitializer {

    public void onStartup ( javax.servlet.ServletContext servletContext ) throws ServletException {
        //System.out.println ("this is the Custom inisilizer method impl...." );
        XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext ();
        webApplicationContext.setConfigLocation ( "classpath:application-configuration.xml" );
        DispatcherServlet dispatcherServlet = new DispatcherServlet ( webApplicationContext );
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet ( "myservlert",dispatcherServlet );
        servletRegistration.setLoadOnStartup ( 1 );
        servletRegistration.addMapping ( "/myproject/*" );

    }
}
