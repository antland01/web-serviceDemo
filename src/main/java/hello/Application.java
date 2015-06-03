/*
 * Application Class
 *
 * Used to start the Spring based Maven project.
 *
 * PHP version 5
 *
 *
 * @author     Anthony Smith <antland01@gmail.com>
 */

package hello;


import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application  extends SpringBootServletInitializer {

 
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
 

    public static void main(String[] args) {
 
      SpringApplication.run(Application.class, args);
	   
     }
	
}