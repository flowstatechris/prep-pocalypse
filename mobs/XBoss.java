import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class XBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XBoss extends World
{
    private GreenfootImage image1;
    private GreenfootSound music2 = new GreenfootSound("xboss.wav");
    private GreenfootSound music3 = new GreenfootSound("xdefeat.wav");
    int delay = 85;
    public XBoss() //spawn the objects needed , set world images and music
    {
        super(700, 700, 1);
        image1 = new GreenfootImage ("X.png");
        image1.scale(700, 700);
        setBackground(image1);
        Spire spire = new Spire();
        addObject ( spire, 647, 147);
        Student student = new Student();
        addObject (student, 25, 144);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        music2.playLoop();
        student.unlock(4);
    }
    public void act()
    {
        if ( getObjects(Spire.class).isEmpty()) { // if boss is dead, stop the boss theme, play victory theme, and remove delay
            music2.stop();
            music3.play();
            delay--;

        }
        if ( getObjects(Spire.class).isEmpty() && getObjects(Student.class).size() != 0 && delay == 0) // if all enemies are dead and the student is alive, proceed level
        {
            music2.stop();
            nextLevel();
        }

        resetLevel();
        
        
    }
    public void nextLevel() // if enemies have died, remove all objects and  go to the next level
    {

        if ( getObjects(Spire.class).isEmpty())
        {

            removeObjects(getObjects(null));

            Greenfoot.setWorld(new Keefe());
        }
    }
    
    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {

        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music2.stop();

            Greenfoot.setWorld(new XBoss());
        }
    }
}
