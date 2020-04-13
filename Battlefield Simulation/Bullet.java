import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectiles
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet(int bulletSpeed, int bulletDirection){
        speed = bulletSpeed;
        direction = bulletDirection;
        setRotation(direction);
    }
    public void act() 
    {
        // Add your action code here.
        move(speed);
        checkDestroyed();
    }    
}
