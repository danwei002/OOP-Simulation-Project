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
    public Bullet(boolean team, int bulletSpeed, int bulletDirection, int bulletDamage){
        this.team = team;
        speed = bulletSpeed;
        direction = bulletDirection;
        damage = bulletDamage;
        setRotation(direction);
    }
    
    public void act() 
    {
        // Add your action code here.
        move(speed);
        checkCollision();
    }    
}
