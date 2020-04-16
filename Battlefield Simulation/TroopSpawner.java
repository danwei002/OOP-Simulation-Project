import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class TroopSpawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TroopSpawner extends Building
{
    private GreenfootImage img = new GreenfootImage("barracks.png");
    
    // Troop spawn delay
    private int spawnDelay;
    
    // Spawn variable used with spawn delay
    private int spawn = 0;
    
    // Used for RNG
    private Random random = new Random();
    
    /**
     * Create a Troop Spawner building.
     * 
     * @param isRed True if this building belongs to the red team, false if blue team.
     * @param width Width of the building.
     * @param height Height of the building.
     * @param maxHP Maximum HP this building has.
     * @param maxCharge Amount of charge the building must accumulate to spawn a new troop.
     * @param delay Rate at which charge is acquired. Larger numbers mean slower charge acquisition.
     */
    public TroopSpawner(boolean isRed, int width, int height, int maxHP, int maxCharge, int delay)
    {
        statBar = new OZDWStatBar(width, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        img.scale(width, height - 10);
        setImage(img);
        
        this.isRed = isRed;
        this.width = width;
        this.height = height;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.currCharge = 0;
        this.maxCharge = maxCharge;
        spawnDelay = delay;
    }
    
    /**
     * Act - do whatever the TroopSpawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (exploding)
        {
            doExplosion();
            return;
        }
        
        if (!statBarDisplayed)
        {
            statBarDisplayed = true;
            summonStatBar(false);
        }
        
        currCharge += spawn / spawnDelay;
        if (spawn == spawnDelay) {spawn = 0;}
        else {spawn++;}
        if (currCharge == maxCharge) {
            spawnTroop();
            currCharge = 0;
        }
        statBar.update(false, currCharge);
    }   
    
    /**
     * Spawn a troop
     */
    public void spawnTroop()
    {
        getWorld().addObject(new Infantry(isRed, 100, 3, 3, 150), getX() + random.nextInt(200) - 100, getY() + random.nextInt(200) - 100);
    }
}
