import greenfoot.*;

public class Caf extends greenfoot.World
{
    // vairables for images/sound
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootSound music1 = new GreenfootSound("cafmusic.wav");

    public Caf() // here i setup the world with the student, gun , and the amount of enemies I want
    {
        super(700, 700, 1);
        image1 = new GreenfootImage ("caf.png");
        image1.scale(700, 700);
        setBackground(image1);
        image2 = new GreenfootImage ("caf.png");
        image2.scale(700, 700);
        Robot robot = new Robot();
        addObject  (robot , 447, 562);
        Robot bot = new Robot();
        addObject ( bot, 667,550);
        Student student = new Student();
        addObject (student, 29, 43);
        Gun gun = new Gun();
        addObject ( gun , student.getX() + 20, student.getY() + -10);
        student.unlock(1);
        music1.playLoop();        
        addObject( new Unlock1(), 356, 13);
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

    public void nextLevel() // go to the next level
    {        
        music1.stop();

        Greenfoot.setWorld(new CafBoss());               
    }

    public void resetLevel() // if the student is dead and the world is clicked, stop all the music and reset the world
    {

        if (  getObjects(Student.class).isEmpty() && Greenfoot.mouseClicked(this))
        {
            music1.stop();

            Greenfoot.setWorld(new Caf());
        }
    }


    
}





