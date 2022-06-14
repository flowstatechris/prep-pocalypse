import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;
    private GreenfootImage image5;
    private GreenfootImage image6;

    public Gun() // all the gun images
    {
        image1 = new GreenfootImage ("pistol.png");
        image2 = new GreenfootImage ("rifle.png");
        image3 = new GreenfootImage ("eagle.png");
        image4 = new GreenfootImage ("boltaction.png");
        image5 = new GreenfootImage ("bible.png");
        image6 = new GreenfootImage ("mjolnir.png");
        setImage(image1);

    }

    public void act() // weapons are told to stick to the player
    {      
        List<Student> students = getWorld().getObjects(Student.class);
        for(Student student:students)
        {
            weaponSwitch();
            if (getImage() == image1) {
                setLocation(student.getX() + 20, student.getY() - 10);
            }
            if (getImage() == image2) {
                setLocation(student.getX() + 12, student.getY() - 10);
            }
            if (getImage() == image3) {
                setLocation(student.getX() + 12, student.getY() - 8);
            }
            if (getImage() == image4) {
                setLocation(student.getX() + 15, student.getY() -10);
            }
            if (getImage() == image5) {
                setLocation(student.getX() + 20, student.getY() -10);
            }
            if (getImage() == image6) {
                setLocation(student.getX() + 20 , student.getY() -10);
            }
        }
    }

    public void weaponSwitch() { //corresponds keyboards keys to weapons slots
        List<Student> students = getWorld().getObjects(Student.class);
        for(Student student:students) {
            if (Greenfoot.isKeyDown ("1") ) {            
                setImage(image1);
            }
            if (Greenfoot.isKeyDown ("2") && student.rifleUnlocked() ) {            
                setImage(image2);
            }
            if (Greenfoot.isKeyDown ("3") && student.eagleUnlocked()) {            
                setImage(image3);
            }
            if (Greenfoot.isKeyDown ("4") && student.boltUnlocked() ) {            
                setImage(image4);
            }
            if (Greenfoot.isKeyDown ("5") && student.bibleUnlocked() ) {            
                setImage(image5);
            }
            if (Greenfoot.isKeyDown ("9") && student.mjolnirUnlocked() ) {            
                setImage(image6);
            }

        
        }
    }
}

