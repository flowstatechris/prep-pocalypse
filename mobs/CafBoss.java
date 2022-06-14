import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CafBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CafBoss extends World
{
    private GreenfootImage image1;
    private GreenfootSound music2 = new GreenfootSound("cafboss.wav");
    private GreenfootSound music3 = new GreenfootSound("cafdefeat.wav");
    int delay = 100; // this is to delay the resetting of the level so the entire boss defeat sound can be played [ applies to all boss levels ]
    public CafBoss() // setting up all the objects, images, and music
    {
        super(700, 700, 1);
        image1 = new GreenfootImage ("caf.png");
        image1.scale(700, 700);
        setBackground(image1);
        Sageworker sage = new Sageworker();
        addObject ( sage, 667, 550);
        music2.playLoop();
        Student student = new Student();
        addObject (student, 29, 43);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        student.unlock(2);
    }

    public void act() 
    {
        if ( getObjects(Sageworker.class).isEmpty()) { // if sage is dead, stop the boss theme, play victory theme, and remove delay
            music2.stop();
            music3.play();
            delay--;

        }
        if ( getObjects(Sageworker.class).isEmpty() && getObjects(Student.class).size() != 0 && delay == 0) // if all enemies are dead and the student is alive, proceed level
        {
            music2.stop();
            nextLevel();
        }

        resetLevel();

    }

    public void nextLevel() // if enemies have died, remove all objects and  go to the next level
    {

        if ( getObjects(Sageworker.class).isEmpty())
        {

            removeObjects(getObjects(null));

            Greenfoot.setWorld(new X());
        }
    }

    
    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {

        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music2.stop();

            Greenfoot.setWorld(new CafBoss());
        }
    }
}

