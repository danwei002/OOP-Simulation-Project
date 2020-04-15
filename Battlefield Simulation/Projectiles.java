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
    
    // Damage this projectile deals
    protected int damage;
    
    // The actor that shot this projectile
    protected Actor shooter;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Check if the projectile collides with any buildings/troops
     * or moves off the world.
     */
    protected void checkCollision()
    {
        Building b = (Building) getOneIntersectingObject(Building.class);
        Troops t = (Troops) getOneIntersectingObject(Troops.class);
        
        if (b != null && b != shooter)
        {
            b.takeDamage(damage);
            getWorld().removeObject(this);
            return;
        }
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
