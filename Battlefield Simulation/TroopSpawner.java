import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TroopSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TroopSpawner extends Building
{
    
    private GreenfootImage img = new GreenfootImage("TroopSpawner.png");
    
    public TroopSpawner(int width, int height, int maxHP, int maxCharge)
    {
        statBar = new OZDWStatBar(width, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        img.scale(width, height);
        setImage(img);
        
        this.width = width;
        this.height = height;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.currCharge = 0;
        this.maxCharge = maxCharge;
    }
    
    /**
     * Act - do whatever the TroopSpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        
    }    
}
