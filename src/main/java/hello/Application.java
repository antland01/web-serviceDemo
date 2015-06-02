package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	/*
	 public void run(String... strings) throws Exception {
	
	  System.out.println("Creating tables");
        jdbcTemplate.execute("drop table stuff if exists");
        jdbcTemplate.execute("create table stuff(" +
                "id int,content varchar(255))");
	  
	 }
*/
}