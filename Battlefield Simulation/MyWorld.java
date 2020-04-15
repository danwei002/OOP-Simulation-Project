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
    TroopSpawner test;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        test = new TroopSpawner(true, 100, 125, 100, 100, 2);
        addObject(test, getWidth() / 2, 100);
        
        addObject(new Infantry(true), getWidth() / 2, 100);
        addObject(new Infantry(true), getWidth() / 2 +100, 100);
        addObject(new Infantry(false), getWidth() / 2 , 700);
        
        test.summonStatBar(false);
    }
}
