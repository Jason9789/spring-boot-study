package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {


    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // init spring container
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class);

        // create spring MVC dispatcher servlet and connect spring container
        DispatcherServlet dispatcher = new DispatcherServlet(appContext);

        // dispatcher servlet 을 servlet container 에 등록
        servletContext.addServlet("dispatcherV2", dispatcher)
                .addMapping("/spring/*");
    }
}
