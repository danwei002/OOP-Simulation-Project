import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Projectiles
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Laser(boolean team, int bulletSpeed, int bulletDirection, int bulletDamage){
        this.team = team;
        speed = bulletSpeed;
        direction = bulletDirection;
        damage = bulletDamage;
        setRotation(direction);
    }
    
    public Laser(boolean team, int bulletSpeed, int bulletDirection, int bulletDamage, String customImageName){
        this.team = team;
        speed = bulletSpeed;
        direction = bulletDirection;
        damage = bulletDamage;
        setRotation(direction);
        GreenfootImage customImage = new GreenfootImage(customImageName);
        customImage.scale(30,30);
        setImage(customImage);
    }
    
    public void act() 
    {
        // Add your action code here.
        move(speed);
        checkCollision();
    } 
}
