import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArtilleryBolt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtilleryBolt extends Projectiles
{
    public ArtilleryBolt(Building shooter, int boltSpeed, int boltDirection, int boltDamage)
    {
        this.shooter = shooter;
        speed = boltSpeed;
        direction = boltDirection;
        damage = boltDamage;
        setRotation(direction);
    }
    
    /**
     * Act - do whatever the ArtilleryBolt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(speed);
        checkCollision();
    }    
}
