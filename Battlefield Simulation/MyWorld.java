import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    TroopSpawner red,blue;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        red = new TroopSpawner(false, 100, 125, 100, 100, 2);
        blue = new TroopSpawner(true, 100, 125, 100, 100, 2);
        addObject(red, getWidth() / 4 * 3, getHeight()/2);
        addObject(blue, getWidth() / 4, getHeight()/2);
        
        addObject(new Infantry(true), 0, getHeight()/2);
        //addObject(new Infantry(true), 100, getHeight()/2 +100);
        addObject(new Infantry(false), getWidth() , getHeight()/2);
        
 
        //addObject(new Artillery(true, 65, 65, 1000, 45, 400), getWidth() / 4, getHeight() - 100);
        //addObject(new Artillery(false, 65, 65, 1000, 45, 200), getWidth() / 2, getHeight() / 2);
    }
}
