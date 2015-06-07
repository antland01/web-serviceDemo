package diskLibary;

/**
 * The purpose of this class is to represent a Disk whether it is a DVD or Blueray.
 * 
 * 
 * @author Anthony Smith
 */



public class Disk 
{
   public String name, description;
   
   
   public Disk()
   {  
   }
   
    public Disk(String name, String description)
   { 
      this.name = name;
      this.description = description;
   }
   
   public String getName()
   {  return name;
   }
   
   public void setName(String name)
   {  this.name = name;
   }
   
   public String getDescription()
   {  return description;
   }
   
   public void setDescription(String description)
   {  this.description = description;
   }
   
} 
