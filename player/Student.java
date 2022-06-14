
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Student extends SmoothMover
{
    /* these are all variables i use to keep track of values that concern the character 
    and its related classes. A lot of this stuff is sent to other classes to 
    get info on the student */
    
    public int speed;
    private GreenfootImage image1;

    Heart heart1 = new Heart();
    Heart heart2 = new Heart();
    Heart heart3 = new Heart();
    Heart heart4 = new Heart();

    private static final int gunReloadTime = 10;
    private  int reloadDelayCount;
    private  int boltDelayCount;
    private  int thorDelayCount;
    private  int holyDelayCount;
    private  int eggDelayCount;
    private boolean isHoldingEagle;
    private boolean isHoldingBible;
    private boolean isHoldingRifle;
    private boolean isHoldingMjolnir; 
    private boolean isHoldingPistol;
    private boolean isHoldingBoltAction;
    int hearts = 4;
    private int boltReloadTime = 75;
    private int holyReloadTime = 100;
    private int thorReloadTime = 50;
    private int eggReloadTime = 45;
    private GreenfootSound music = new GreenfootSound ("gameover.wav");
    private  GreenfootSound music2 =  new GreenfootSound("shot.wav");
    private  GreenfootSound music3 =  new GreenfootSound("scripture.wav");
    private  GreenfootSound music4 =  new GreenfootSound("lightning.wav");
    int unlock ;
    public Student() // setup booleans , image and reloadtime
    {
        reloadDelayCount = 9;
        speed = 4;
        image1 = new GreenfootImage ("student.png");
        setImage(image1);
        isHoldingEagle = false;
        isHoldingBible = false;
        isHoldingRifle = false;
        isHoldingMjolnir = false;
        isHoldingPistol = true;
        isHoldingBoltAction = false;
    }
    public void unlock(int amount) // method to increase unlock variable
    {
        unlock =  unlock + amount;
        
    }
    public int unlock() // method so I can access unlock in any class i want
    {
        return(unlock);
        
    }
    public void act() 
    {
        holding();
        controls();
        reloadDelayCount++;
        boltDelayCount++;
        thorDelayCount++;
        eggDelayCount++;
        holyDelayCount++;
        HeartData();
        updateHearts();

        hearts();
    } 

    public boolean rifleUnlocked() 
    {
        if (unlock >= 1)
        {
            return true;

        }
        else {
            return false;

        }
    }

    public boolean eagleUnlocked()
    {
        if (unlock() >= 3)

        {
            return true;

        }
        else {
            return false;

        }
    }

    public boolean boltUnlocked()
    {
        if (unlock >= 5)

        {
            return true;

        }
        else {

            return false;
        }
    }

    public boolean bibleUnlocked()
    {
        if (unlock >= 7)
        {
            return true;

        }
        else{
            return false;

        }
    }

    public boolean mjolnirUnlocked()
    {        
        return true;
    }

    public void controls() // controls for the student, and I use a list so all of my booleans can work together with errors
    {                

        List<Student> students = getWorld().getObjects(Student.class);
        for(Student student:students)
        {
            if (Greenfoot.isKeyDown("a") )         
            {   setLocation ( getX() - speed, getY() );

            }
            if (Greenfoot.isKeyDown("d")) 
            {
                setLocation ( getX() + speed, getY());     
            }
            if (Greenfoot.isKeyDown("w")) 
            {
                setLocation ( getX() , getY() - speed);
            }
            if (Greenfoot.isKeyDown("s")) 
            {
                setLocation ( getX(), getY() + speed);
            }
            if (Greenfoot.isKeyDown("space")) /* here I make sure the weapon is 
            loaded and has been unlocked by the player */
            {
                // i also make different ammo for most weapons
                if (isHoldingPistol && reloadDelayCount >= gunReloadTime) {

                    Bullet bullet = new Bullet (getVelocity() , getRotation());
                    getWorld().addObject (bullet, student.getX() + 17, student.getY() - 8);
                    bullet.move ();
                    reloadDelayCount = 0;
                    music2.play();
                }
                if (isHoldingRifle && rifleUnlocked() &&  reloadDelayCount >= gunReloadTime)
                {

                    Bullet bullet = new Bullet (getVelocity() , getRotation());
                    getWorld().addObject (bullet, student.getX() + 17, student.getY() - 8);
                    bullet.move ();
                    reloadDelayCount = 0;
                    music2.play();
                }
                if (isHoldingEagle && eagleUnlocked() &&   eggDelayCount >= eggReloadTime){
                    Egg egg = new Egg(getVelocity(), getRotation() );
                    getWorld().addObject (egg, student.getX() + 17, student.getY() - 8);
                    egg.move ();
                    eggDelayCount = 0;
                    music2.play();
                } 
                if ( isHoldingBoltAction && boltUnlocked() && boltDelayCount >= boltReloadTime) {
                    BoltBullet boltbullet = new BoltBullet (getVelocity() , getRotation());
                    getWorld().addObject (boltbullet, student.getX() + 17, student.getY() - 8);
                    boltbullet.move ();
                    boltDelayCount = 0;
                    music2.play();
                }
                if (isHoldingBible && bibleUnlocked() && holyDelayCount >= holyReloadTime) {
                    Scripture old = new Scripture(getVelocity(), getRotation() );
                    getWorld().addObject (old, student.getX() + 17, student.getY() - 8);
                    old.move ();
                    holyDelayCount = 0;
                    music3.play();
                }
                if (isHoldingMjolnir && mjolnirUnlocked() && thorDelayCount >= thorReloadTime) {
                    Lightning strike = new Lightning(getVelocity(), getRotation() );
                    getWorld().addObject (strike, student.getX() + 17, student.getY() - 8);
                    strike.move ();
                    thorDelayCount = 0;
                    music4.play();
                }
            }   
        }
    }

    public void holding() { // this is to check what weapon the student holds
        List<Student> students = getWorld().getObjects(Student.class);
        for(Student student:students)
        {
            if (Greenfoot.isKeyDown("1") ) {                
                isHoldingPistol = true;                isHoldingEagle = false;
                isHoldingBoltAction = false;
                isHoldingBible = false;
                isHoldingRifle = false;
                isHoldingMjolnir = false;
            }
            if (Greenfoot.isKeyDown("2") ) {                
                isHoldingPistol = false;                isHoldingEagle = false;
                isHoldingBible = false;
                isHoldingBoltAction = false;
                isHoldingRifle = true;
                isHoldingMjolnir = false;
            }
            if (Greenfoot.isKeyDown("3") ) {                
                isHoldingPistol = false;                isHoldingEagle = true;
                isHoldingBible = false;
                isHoldingRifle = false;
                isHoldingBoltAction = false;
                isHoldingMjolnir = false;
            }
            if (Greenfoot.isKeyDown("4") ) {                
                isHoldingPistol = false;                isHoldingEagle = false;
                isHoldingBible = false;
                isHoldingRifle = false;
                isHoldingBoltAction = true;
                isHoldingMjolnir = false;
            }
            if (Greenfoot.isKeyDown("5") ) {                
                isHoldingPistol = false;                isHoldingEagle = false;
                isHoldingBible = true;
                isHoldingRifle = false;
                isHoldingBoltAction = false;
                isHoldingMjolnir = false;
            }
            if (Greenfoot.isKeyDown("9") ) {                
                isHoldingPistol = false;                isHoldingEagle = false;
                isHoldingBible = false;
                isHoldingRifle = false;
                isHoldingBoltAction = false;
                isHoldingMjolnir = true;
            }
        }

    } 

    public int hearts() { // this is so I can use the heart value in different classes
        return(hearts);

    }

    public void HeartData() // add 4 hearts in the top left
    {
        Heart heart1 = new Heart();
        getWorld().addObject ( heart1, 26, 25);

        Heart heart2 = new Heart();
        getWorld().addObject ( heart2, 68, 25);

        Heart heart3 = new Heart();
        getWorld().addObject ( heart3, 109, 25);

        Heart heart4 = new Heart();
        getWorld().addObject ( heart4, 150, 25);
    }

    public void adjustHealth( int amount) // adjusts the hearts value based on input from other actors
    {
        hearts = hearts + amount;
        if(hearts() <= 0) { // if health is 0: stop the game, remove everything, game over screen/music
            hearts = 0;
            Greenfoot.stop();
            World world = getWorld();
            world.removeObjects(getWorld().getObjects(Student.class));

            world.addObject(new GameInfo(), world.getWidth()/2, world.getHeight()/2); 
            music.play();
        }
        if(hearts() > 4) // cant have more than 4 hearts
        {hearts = 4;
        }
        updateHearts(); // update display if number of hearts is changed
    }

    public void updateHearts() // change which hearts display on the indicator based off health value
    {
        if (hearts() == 3)
        {
            getWorld().removeObjects(getWorld().getObjectsAt(150  , 25, Heart.class));

        }
        if (hearts() == 2)
        {           

            getWorld().removeObjects(getWorld().getObjectsAt(150  , 25, Heart.class));
            getWorld().removeObjects(getWorld().getObjectsAt(109  , 25, Heart.class));

        }
        if (hearts() == 1)
        {
            getWorld().removeObjects(getWorld().getObjectsAt(150  , 25, Heart.class));
            getWorld().removeObjects(getWorld().getObjectsAt(109  , 25, Heart.class));

            getWorld().removeObjects(getWorld().getObjectsAt(68  , 25, Heart.class));

        }
    } 

}
