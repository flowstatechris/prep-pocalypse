
import greenfoot.*;
public class GameInfo extends Actor
{
    
    
    
 // this is the gameover message
   
    public GameInfo()
    {
        
        setImage(new GreenfootImage("Game Over, Run the scenario and click twice to replay", 30, Color.WHITE, Color.BLACK));
        
    }
    
    public void act()
    {
        
        
        if (Greenfoot.mouseClicked(this))
        {
             getWorld().removeObject(this);
        }
    }
}