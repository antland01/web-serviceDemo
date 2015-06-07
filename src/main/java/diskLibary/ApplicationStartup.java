package diskLibary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup 
implements ApplicationListener<ContextRefreshedEvent> {
 @Autowired
    JdbcTemplate jdbcTemplate;
  /*
   * This method is called during Spring's startup.
   * 
   * @param event Event raised when an ApplicationContext gets initialized or
   * refreshed.
   */
  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
 jdbcTemplate.execute("drop table bluerays if exists");
        jdbcTemplate.execute("CREATE TABLE `bluerays` (`Title` text NOT NULL,`Description` text NOT NULL)");
        
         jdbcTemplate.update("INSERT INTO `bluerays` (`Title` ,`Description`)" +
                  "VALUES ('"+"Harry Potter"+"', '"+"Good movie"+"');");
         

        
        jdbcTemplate.execute("drop table dvds if exists");
        jdbcTemplate.execute("CREATE TABLE `dvds` (`Title` text NOT NULL,`Description` text NOT NULL)");
        
             
  }
  
  
 
} 