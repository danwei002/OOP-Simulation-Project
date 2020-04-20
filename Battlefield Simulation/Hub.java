import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Hub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hub extends Building
{
    private GreenfootImage blueHubImg = new GreenfootImage("blueHubImage.png");
    private GreenfootImage redHubImg = new GreenfootImage("redHubImage.png");
    
    // Building spawn delay
    private int spawnDelay;
    
    // Spawn variable used with spawn delay
    private int spawn = 0;
    
    // Used for RNG
    private Random random = new Random();
    
    // Track the active buildings on the field
    private boolean[] activeBuildings = new boolean[8];
    
    public Hub(boolean isRed, int width, int height, int maxHP, int maxCharge, int delay)
    {
        statBar = new OZDWStatBar(width - 50, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        this.width = width;
        this.height = height;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.currCharge = 0;
        this.maxCharge = maxCharge;
        this.isRed = isRed;
        spawnDelay = delay;
        if (isRed)
        {
            redHubImg.scale(width, height);
            setImage(redHubImg);
        }
        else
        {
            blueHubImg.scale(width, height);
            setImage(blueHubImg);
        }
    }
    
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
        
        updateBuildings();
        if (currCharge < maxCharge)
        {
            currCharge += spawn / spawnDelay;
        }
        if (spawn == spawnDelay) {spawn = 0;}
        else {spawn++;}
        if (currCharge >= maxCharge && !allBuildingsActive()) {
            spawnBuilding(); 
            currCharge = 0;
        }
        statBar.update(false, currCharge);
    }    
    
    private void spawnBuilding()
    {
        if (isRed)
        {
            for (int i = 0; i < 8; i++)
            {
                if (activeBuildings[i]) {continue;}
                World w = getWorld();
                if (i == 0){w.addObject(new TroopSpawner(true, 100, 110, 500, 100, 2), getWidth() / 9, getHeight() / 4 - 50); return;}
                else if (i == 1) {w.addObject(new TroopSpawner(true, 100, 110, 500, 100, 2), getWidth() / 9, getHeight() / 4 * 3 + 50); return;}
                else if (i == 2) {w.addObject(new DefenseTower(true, 130, 130, 999, 100, 1), getWidth() / 4, getHeight()/2-130); return;}
                else if (i == 3) {w.addObject(new DefenseTower(true, 130, 130, 999, 100, 1), getWidth() / 4, getHeight()/2+130); return;}
            }
        }
        else
        {
            for (int i = 0; i < 8; i++)
            {
                if (activeBuildings[i]) {continue;}
                World w = getWorld();
                if (i == 0){w.addObject(new TroopSpawner(false, 100, 110, 500, 100, 2), getWidth() / 9 * 8, getHeight() / 4 - 50); return;}
                else if (i == 1) {w.addObject(new TroopSpawner(false, 100, 110, 500, 100, 2), getWidth() / 9 * 8, getHeight() / 4 * 3 + 50); return;}
                else if (i == 2) {w.addObject(new DefenseTower(false, 130, 130, 999, 100, 1), getWidth() / 4 * 3, getHeight()/2-130); return;}
                else if (i == 3) {w.addObject(new DefenseTower(false, 130, 130, 999, 100, 1), getWidth() / 4 * 3, getHeight()/2+130); return;}
            }
        }
    }
    
    /**
     * Sees which buildings are still standing
     */
    private void updateBuildings()
    {
        if (isRed)
        {
            for (int i = 0; i < 8; i++)
            {
                if (i == 0) // Upper spawner
                {
                    List<TroopSpawner> b = (List<TroopSpawner>) getWorld().getObjectsAt(getWidth() / 9, getHeight() / 4 - 50, TroopSpawner.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 1) // Lower spawner
                {
                    List<TroopSpawner> b = (List<TroopSpawner>) getWorld().getObjectsAt(getWidth() / 9, getHeight() / 4 * 3 + 50, TroopSpawner.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 2) // Upper defense tower
                {
                    List<DefenseTower> b = (List<DefenseTower>) getWorld().getObjectsAt(getWidth() / 4, getHeight()/2-130, DefenseTower.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 3) // Lower defense tower
                {
                    List<DefenseTower> b = (List<DefenseTower>) getWorld().getObjectsAt(getWidth() / 4, getHeight()/2+130, DefenseTower.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
            }
        }
        else
        {
            for (int i = 0; i < 8; i++)
            {
                if (i == 0) // Upper spawner
                {
                    List<TroopSpawner> b = (List<TroopSpawner>) getWorld().getObjectsAt(getWidth() / 9 * 8, getHeight() / 4 - 50, TroopSpawner.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 1) // Lower spawner
                {
                    List<TroopSpawner> b = (List<TroopSpawner>) getWorld().getObjectsAt(getWidth() / 9 * 8, getHeight() / 4 * 3 + 50, TroopSpawner.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 2) // Upper defense tower
                {
                    List<DefenseTower> b = (List<DefenseTower>) getWorld().getObjectsAt(getWidth() / 4 * 3, getHeight()/2-130, DefenseTower.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
                else if (i == 3) // Lower defense tower
                {
                    List<DefenseTower> b = (List<DefenseTower>) getWorld().getObjectsAt(getWidth() / 4 * 3, getHeight()/2+130, DefenseTower.class);
                    if (b.size() == 0) {activeBuildings[i] = false;}
                    else {activeBuildings[i] = true;}
                }
            }
        }
    }
    
    private boolean allBuildingsActive()
    {
        for (int i = 0; i < 4; i++)
        {
            if (!activeBuildings[i]) {return false;}
        }
        return true;
    }
    
    /**
     * Utility method to get world width
     */
    private int getWidth()
    {
        return getWorld().getWidth();
    }
    
    /**
     * Utility method to get world height
     */
    private int getHeight()
    {
        return getWorld().getHeight();
    }
}
