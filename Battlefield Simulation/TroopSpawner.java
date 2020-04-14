import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public TroopSpawner(int width, int height, int maxHP, int maxCharge, int delay)
    {
        statBar = new OZDWStatBar(width, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        img.scale(width, height - 10);
        setImage(img);
        
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
        currCharge++;
        if (spawn == spawnDelay) {spawn = 0;}
        if (currCharge == maxCharge) {
            getWorld().addObject(new Infantry(true, 100, 3, 3, 150), getX(), getY());
            currCharge = 0;
        }
        statBar.update(false, currCharge);
    }    
}
