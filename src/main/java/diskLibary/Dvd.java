package diskLibary;

/**
 * The purpose of this class is to represent a Dvd.
 * 
 * 
 * @author Anthony Smith
 */


public class Dvd extends Disk
{
   public Dvd()
   {  
       super();
   }
   
      public Dvd(String name, String description)
   {  
       super.name = name;
       super.description = description;
   }
} 