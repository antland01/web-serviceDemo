package diskLibary;

/**
 * The purpose of this class is to be the servlet to handle the blueray disks in the collection
 * 
 * 
 * @author Anthony Smith
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("disk")
public class DiskController {
    
@Autowired
 JdbcTemplate jdbcTemplate;
  
  @RequestMapping(value="/",  method=RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping(value="/error/")
    public String error(Model model) {
        return "index";
    }
      
      
   
      
   @RequestMapping(value="/bluerayform",  method=RequestMethod.GET)
    public String blueray(Model model) {

         jdbcTemplate.update("INSERT INTO `bluerays` (" + "`Title` ,`Description`)" +
                  "VALUES ('"+"Harry Potter"+"', '"+"Good movie"+"');");
         
        List<Blueray> bluerayResults = jdbcTemplate.query(
                "select Title, Description from bluerays",
                new RowMapper<Blueray>() {
                    @Override
                    public Blueray mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new  Blueray(rs.getString("Title"),rs.getString("Description"));
                    }
                });
      
 
        model.addAttribute("bluerays", bluerayResults);
        
        model.addAttribute("bluerayform", new Blueray());
        return "blueray";
    }
      

    @RequestMapping(value="/bluerayform", method=RequestMethod.POST)
    public String blueraySubmit(@ModelAttribute Blueray bluerayForm, Model model) {
       String name = bluerayForm.getName();
       String description = bluerayForm.getDescription();
        
        jdbcTemplate.update("INSERT INTO `bluerays` (`Title` ,`Description`)" +
                  "VALUES ('"+name+"', '"+description+"');"); 
                 
        
        return "redirect:/disk/bluerayform";
    }

      
   @RequestMapping(value="/dvdform",  method=RequestMethod.GET)
    public String dvd(Model model) {
       
         jdbcTemplate.update("INSERT INTO `dvds` (" + "`Title` ,`Description`)" +
                  "VALUES ('"+"Harry Potter"+"', '"+"Good movie"+"');");
         
        List<Dvd> results = jdbcTemplate.query(
                "select Title, Description from dvds",
                new RowMapper<Dvd>() {
                    @Override
                    public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new  Dvd(rs.getString("Title"),rs.getString("Description"));
                    }
                });

    
        model.addAttribute("dvds", results);
        
        model.addAttribute("dvdform", new Dvd());
        return "dvd";
    }
    
      @RequestMapping(value="/dvdform", method=RequestMethod.POST)
    public String dvdSubmit(@ModelAttribute Dvd dvdForm, Model model) {
       String name = dvdForm.getName();
       String description = dvdForm.getDescription();
        
        jdbcTemplate.update("INSERT INTO `dvds` (`Title` ,`Description`)" +
                  "VALUES ('"+name+"', '"+description+"');"); 
                 
        
        return "redirect:/disk/dvdform";
    }

}
