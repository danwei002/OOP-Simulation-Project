import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectiles extends Actor
{
    /**
     * Act - do whatever the Projectiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int direction;
    protected int speed;
    public void act() 
    {
        // Add your action code here.
    }    
    public void checkDestroyed(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}