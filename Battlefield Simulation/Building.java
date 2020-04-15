import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Building extends Actor
{
    // Every building has a stat bar
    protected OZDWStatBar statBar;
   
    // Every building has some amount of maximum HP
    protected int maxHP;
    
    // Building's current HP
    protected int currHP;
    
    // Some buildings will require a "charge value" (like a cooldown on abilities)
    protected int maxCharge;
    
    // Building's current charge
    protected int currCharge;
    
    // Dimensions
    protected int width;
    protected int height;
    
    /**
     * Act - do whatever the Building wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * Put the building's stat bar either above or below the building
     * 
     * @param above True if above building, false if below
     */
    protected void summonStatBar(boolean above)
    {
        if (above) 
        {
            getWorld().addObject(statBar, getX(), getY() - height / 2);
        }
        else
        {
            getWorld().addObject(statBar, getX(), getY() + height / 2);
        }
        
    }
    
    /**
     * Make the building take some amount of damage.
     * 
     * @param damage Amount of damage dealt
     */
    protected void takeDamage(int damage)
    {
        currHP -= damage;
        statBar.update(true, currHP);
    }
}
