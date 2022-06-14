import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class X here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class X extends World
{
     private GreenfootImage image1;
    
    private GreenfootSound music1 = new GreenfootSound("xmusic.wav");
    
     private GreenfootSound music3 = new GreenfootSound("xdefeat.wav");
    
    public X() // spawn the objects needed , set the images and music
    {
        super(700, 700, 1);
        image1 = new GreenfootImage ("X.png");
        image1.scale(700, 700);
        setBackground(image1);
        Robot robot = new Robot();
        addObject  (robot , 647, 147);
        Robot bot = new Robot();
        addObject ( bot, 501,147);
        Robot bot3 = new Robot();
        addObject ( bot3, 557, 147);
        Student student = new Student();
        addObject (student, 25, 144);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        student.unlock(3);
        music1.playLoop();
       addObject ( new Unlock2() , 355 , 15 );
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
        
        Greenfoot.setWorld(new XBoss()); 
    }
    
    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {
        
        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music1.stop();
            
            Greenfoot.setWorld(new X());
    }
}
}
