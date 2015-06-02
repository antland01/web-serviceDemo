package hello;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/*
 * Greeting Controller
 *
 * An example of a controller that will handle everything in the project.
 *
 * PHP version 5
 *
 *
 * @author     Anthony Smith <antland01@gmail.com>
 */

@Controller
public class GreetingController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    
    
/*
 * Greeting method. 
 *
 * Greeting someone with the name they enter as a parameter. If not it just says Hello World. From 
   the basic Spring tutorial.
 */
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
    @RequestMapping("/jsp_example")
    public String jsp_example() {
       System.out.println("JSP Here");
        return "jsp_example";
    }
    
    
/*
 * Test Method
 *
 * Like greeting but adds two numbers together. 
 */
    @RequestMapping("/test")
    public String test(@RequestParam(value="total", required=false, defaultValue="15") String total, Model model) {
       // model.addAttribute("name", name);
        String[] numberz = total.split("");
        int result = 0;
        
        for(int x = 0; x < numberz.length; x = x+1) {
          result += Integer.parseInt(numberz[x]);
        }
      total = Integer.toString(result);
                model.addAttribute("total", total);
        return "test";
    }
    
/*
 * Greeting form method
 *
 * Loads the Greeting orm and creates the table for it to be added to. 
 */
	    @RequestMapping(value="/Greetingform", method=RequestMethod.GET)
    public String Greetingform(Model model) {
	 System.out.println("Creating tables");
        jdbcTemplate.execute("drop table stuff if exists");
        jdbcTemplate.execute("create table stuff(" +
                "id int,content varchar(255))");
        model.addAttribute("Greetingform", new Greetingform());
        return "Greetingform";
    }

/*
 * Greeting Submit Method
 *
 * Takes in the Greeting adds it to the view and inserts it into the database. 
 */
    @RequestMapping(value="/Greetingform", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greetingform greetingForm, Model model) {
    
    jdbcTemplate.update("INSERT INTO stuff(id,content) values(?,?)",greetingForm.getId(),greetingForm.getContent());
                   
        
        model.addAttribute("Greetingform", greetingForm);
        return "result";
    }
    
/*
 * Results DB Method
 *
 * Displays the results out of the Database for the Greet form method. Takes in the ID of the message 
 */
	    @RequestMapping(value="/resultdb")
    public String resultdb(@RequestParam(value="id", required=false, defaultValue="1") String id, Model model) {
        
       System.out.println("Querying for customer records where first_name = 'Josh':");
        List<Greetingform> results = jdbcTemplate.query(
                "select id, content from stuff where id = ?", new Object[] { id },
                new RowMapper<Greetingform>() {
                    @Override
                    public Greetingform mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Greetingform(rs.getLong("id"), rs.getString("content"));
                    }
                });
        
         System.out.println(results.get(0).getContent());

          model.addAttribute("id",results.get(0).getId() );
          model.addAttribute("content", results.get(0).getContent());
	return "resultdb";	
      
    }



}