import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Keefe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keefe extends World
{
     private GreenfootImage image1;
    
    private GreenfootSound music1 = new GreenfootSound("kmusic.wav");
    
     
    public Keefe() // add objects, set images and music
    {
        super(776, 454, 1);
        image1 = new GreenfootImage ("keefe.png");
        image1.scale(776, 454);
        setBackground(image1);
        Robot robot = new Robot();
        addObject  (robot , 499, 409);
        Robot bot = new Robot();
        addObject ( bot, 617,409);
        Robot bot3 = new Robot();
        addObject ( bot3, 736, 409);
        Robot bot4 = new Robot();
        addObject ( bot4, 548, 162);
        Robot bot5 = new Robot();
        addObject ( bot5, 682, 162);
        Student student = new Student();
        addObject (student, 25, 144);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        student.unlock(6);
        music1.playLoop();
        addObject ( new Unlock3() , 408, 12);
        
    }
   public void act() 
    {
          if ( getObjects(Robot.class).isEmpty() && getObjects(Student.class).size() != 0) // if all robots are dead and the student is alive, boss time
        {
            music1.stop();
            nextLevel();
        }
        
        resetLevel();
    
    }
    public void nextLevel() // proceed to boss level
    {
        music1.stop();
        
        Greenfoot.setWorld(new KeefeBoss()); 
    }
    
    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {
        
        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music1.stop();
            
            Greenfoot.setWorld(new Keefe());
    }
}
}
