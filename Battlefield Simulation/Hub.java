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
    
    public Hub(boolean isRed, int width, int height, int maxHP, int maxCharge, int delay)
    {
        statBar = new OZDWStatBar(width - 50, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        this.width = width;
        this.height = height;
        this.maxHP = maxHP;
        this.currHP = maxHP;
        this.currCharge = 0;
        this.maxCharge = maxCharge;
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
            summonStatBar(true);
        }
        
        currCharge += spawn / spawnDelay;
        if (spawn == spawnDelay) {spawn = 0;}
        else {spawn++;}
        if (currCharge == maxCharge) {
            //spawnTroop();
            currCharge = 0;
        }
        statBar.update(false, currCharge);
    }    
}
