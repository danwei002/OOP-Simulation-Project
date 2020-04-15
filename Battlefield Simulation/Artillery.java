import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.lang.Math;

/**
 * Write a description of class Artillery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Artillery extends Building
{
    private GreenfootImage artilleryRed = new GreenfootImage("artilleryRed.png");
    private GreenfootImage artilleryBlue = new GreenfootImage("artilleryBlue.png");
    
    private int fireRate;
    private int fireDelay;
    
    public Artillery(boolean isRed, int width, int height, int maxHP, int fireRate)
    {
        this.isRed = isRed;
        this.width = width;
        this.height = height;
        this.maxHP = maxHP;
        this.fireRate = fireRate;
        
        if (isRed)
        {
            artilleryRed.scale(width, height);
            setImage(artilleryRed);
        }
        else
        {
            artilleryBlue.scale(width, height);
            setImage(artilleryBlue);
        }
    }
    
    /**
     * Act - do whatever the Artillery wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        target();
        fireDelay++;
        if (fireDelay > fireRate)
        {
            fireDelay = 0;
        }
    }    
       
    public void attack()
    {
        getWorld().addObject(new ArtilleryBolt(this, 15, getRotation(), 15), getX(), getY());
    }   
    
    /**
     * Target a building. Artilleries only target enemy buildings.
     */
    public void target()
    {
        List<Building> buildings = (List<Building>) getWorld().getObjects(Building.class);
        if (buildings.size() == 0) {return;} // If there are no buildings to target
        
        Building closestBuilding = null;
        double closestDistance = Double.MAX_VALUE;
        for (Building b: buildings)
        {
            if (b.getTeam() != this.getTeam() && b != this) 
            {
                double distanceTo = getDistance(b);
                if (distanceTo < closestDistance)
                {
                    closestDistance = distanceTo;
                    closestBuilding = b;
                }
            }
        }
        
        if (closestBuilding != null)
        {
            turnTowards(closestBuilding.getX(), closestBuilding.getY());
            if (fireDelay == fireRate)
            {
                attack();
            }
        }
    }
    
    /**
     * Utility function to get the distance a building is away
     * from the artillery.
     */
    private double getDistance(Building other)
    {
        return Math.sqrt(Math.pow(other.getX() - this.getX(), 2) + Math.pow(other.getY() - this.getY(), 2));
    }
}
