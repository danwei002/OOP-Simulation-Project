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
    DefenseTower redtower1,redtower2,bluetower1,bluetower2;
    
    public MyWorld()
    {    
        super(960, 640, 1);
        
        GreenfootImage background = new GreenfootImage("background.jpeg");
        setBackground(background);
        
        red = new TroopSpawner(false, 100, 125, 100, 100, 1);
        blue = new TroopSpawner(true, 100, 125, 100, 100, 1);
        
        redtower1 = new DefenseTower(false, 130, 130, 999, 100, 1);
        redtower2 = new DefenseTower(false, 130, 130, 999, 100, 1);
        bluetower1 = new DefenseTower(true, 130, 130, 999, 100, 1);
        bluetower2 = new DefenseTower(true, 130, 130, 999, 100, 1);
        
        addObject(red, getWidth() / 8 * 7, getHeight()/2);
        addObject(blue, getWidth() / 8, getHeight()/2);
        
        addObject(redtower1, getWidth() / 4 * 3, getHeight()/2-100);
        addObject(redtower2, getWidth() / 4 * 3, getHeight()/2+100);
        
        addObject(bluetower1, getWidth() / 4, getHeight()/2-100);
        addObject(bluetower2, getWidth() / 4, getHeight()/2+100);
        
        addObject(new Infantry(true), 0, getHeight()/2);
        //addObject(new Infantry(true), 100, getHeight()/2 +100);
        addObject(new Infantry(false), getWidth() , getHeight()/2);
        
        addObject(new Ninja(true), 0, getHeight()/2+20);
        addObject(new Ninja(false), getWidth() , getHeight()/2-20);
        
        addObject(new Medic(true), 0, getHeight()/2+20);
        addObject(new Medic(false), getWidth() , getHeight()/2-20);
 
        //addObject(new Artillery(true, 65, 65, 1000, 45, 400), getWidth() / 4, getHeight() - 100);
        //addObject(new Artillery(false, 65, 65, 1000, 45, 200), getWidth() / 2, getHeight() / 2);
    }
    
}
