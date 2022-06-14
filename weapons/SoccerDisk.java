import greenfoot.*; 

public class SoccerDisk extends SmoothMover
{

    Student student = new Student();
    private GreenfootImage image1 = new GreenfootImage ("disk.png");
    
    public SoccerDisk()
    {
        setImage(image1);
        image1.scale(144 , 144);

    }

    public SoccerDisk(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 10));

    }

    public void act()
    {
        move(-5);
        damage();

    }

    private void damage() // if you hit a student , kill him
    {
        Student student = (Student)
            getOneIntersectingObject(Student.class);
        if (isTouching(Student.class) || isAtEdge())
        {
            
                if (isTouching(Student.class))
                {
                    student.adjustHealth(-4);

                }

                getWorld().removeObject(this);
            

        }
    }
}
