package org.baeldung.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;




public class Bootstrap implements WebApplicationInitializer {
    private static final Logger logger = LogManager.getRootLogger();

    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.getServletRegistration("default").addMapping("/resource/*");

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        logger.info("Bootstrap .. onStartup()");

        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(ServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "springDispatcher", new DispatcherServlet(context)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.htm");
    }
}
