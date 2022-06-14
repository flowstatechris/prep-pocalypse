import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Hearts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heart extends Actor
{
    private GreenfootImage image1;
    
    public Heart(){
        image1 = new GreenfootImage ("heart.png");
        setImage(image1);
        image1.scale( 45, 40);
                                   
        
        
    }
    public void act() 
    {
        
    }    
}
