import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public Hub(boolean isRed, int width, int height, int maxHP, int maxCharge, int delay)
    {
        statBar = new OZDWStatBar(width, height / 6, 5, maxHP, maxHP, 0, maxCharge);
        
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
        // Add your action code here.
    }    
}
