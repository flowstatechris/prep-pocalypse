import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends World
{
    private GreenfootImage image1;
    private GreenfootSound music2 = new GreenfootSound("finalboss.wav");
    private GreenfootSound music3 = new GreenfootSound("victory.wav");
    int delay = 150; // the delay is used to delay the act method so the entire theme of victory can be played
    public FinalBoss() // set up the objects, images and sound needed
    {
        super(700, 700, 1);
        image1 = new GreenfootImage ("finalroom.png");
        image1.scale(700, 700);
        setBackground(image1);
        MrBen mrben  = new MrBen();
        addObject (mrben , 585, 633);
        Student student = new Student();
        addObject (student, 160, 179);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        music2.playLoop();
        student.unlock(8);
        addObject ( new Unlock4(), 329 , 27);
    }
    public void act()
    {
        if ( getObjects(MrBen.class).isEmpty()) { // if sage is dead, stop the boss theme, play victory theme, and remove delay
            music2.stop();
            music3.play();
            delay--;

        }
        if ( getObjects(MrBen.class).isEmpty() && getObjects(Student.class).size() != 0 && delay == 0) // if all enemies are dead and the student is alive, proceed level
        {
            music2.stop();
            nextLevel();
        }

        resetLevel();
        
        
    }
    public void nextLevel() // if enemies have died, remove all objects and  go to the next level
    {

        if ( getObjects(MrBen.class).isEmpty())
        {

            removeObjects(getObjects(null));

            Greenfoot.setWorld( new Victory());
        }
    }
    
    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {

        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music2.stop();

            Greenfoot.setWorld(new FinalBoss());
        }
    }
}
