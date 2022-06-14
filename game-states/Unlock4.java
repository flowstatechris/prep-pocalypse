
import greenfoot.*;
public class Unlock4 extends Actor
{
    
    
    
 
   
    public Unlock4() // display 4th unlock message
    {
        
       setImage(new GreenfootImage("Bible (King James Edition) Unlocked! Press 5 to equip.", 30, Color.BLACK, Color.WHITE));
   
    }
    
    public void act() // conditions where this object is removed
    {
        
        
        if (Greenfoot.mouseClicked(this))
        {
             getWorld().removeObject(this);
        
    }
    if (Greenfoot.isKeyDown("space"))
        {
            getWorld().removeObject(this);
            
        }
}
}
