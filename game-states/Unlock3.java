
import greenfoot.*;
public class Unlock3 extends Actor
{
    
    
    
 
   
    public Unlock3() // 3rd unlock message
    {
        setImage(new GreenfootImage("Boltaction Sniper Unlocked! Press 4 to equip.", 30, Color.BLACK, Color.WHITE));
   
    }
    
    public void act() // how to remove this
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
