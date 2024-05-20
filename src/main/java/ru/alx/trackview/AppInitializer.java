package ru.alx.trackview;

//import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.alx.trackview.config.HibernateConfig;
import ru.alx.trackview.config.SecurityConfig;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class, SecurityConfig.class, HibernateConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));

//		servletCxt.setInitParameter("spring.profiles.active", "dev");

        // Create and register the DispatcherServlet
        AnnotationConfigWebApplicationContext servletRegisterer = new AnnotationConfigWebApplicationContext();
        servletRegisterer.register(ServletMvcConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet", new DispatcherServlet(servletRegisterer));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

}
