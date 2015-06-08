package diskLibary;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Disk Web Service Controller
 *
 * Anothr example of a controller that wil handle the Web Service work seperately.
 *
 *
 *
 * @author     Anthony Smith <antland01@gmail.com>
 */

@RestController
public class DiskWSController {

@Autowired
 JdbcTemplate jdbcTemplate;
  
   
    
/*
 * Blueray WS Method
 *
 * Returns a the list of blueray disks as JSON for webservice purposes.
 */
    @RequestMapping("/bluerayws")
    public List<Blueray> bluerayws() {
      List<Blueray> bluerayResults = jdbcTemplate.query("select Title, Description from bluerays",
                new RowMapper<Blueray>() {
                    @Override
                    public Blueray mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new  Blueray(rs.getString("Title"),rs.getString("Description"));
                    }
                });
        return bluerayResults;
        
    }
    
/*
 * Dvd WS Method
 *
 * Returns a the list of Dvd disks as JSON for webservice purposes.
 */
    @RequestMapping("/dvdws")
    public List<Dvd> dvdws() {
      List<Dvd> dvdResults = jdbcTemplate.query("select Title, Description from dvds",
                new RowMapper<Dvd>() {
                    @Override
                    public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new  Dvd(rs.getString("Title"),rs.getString("Description"));
                    }
                });
        return dvdResults;
        
    }
}