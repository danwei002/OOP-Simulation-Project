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
        
        // Hub spawn locations?
        Hub redHub = new Hub(true, 125, 125, 5000, 200, 5);
        Hub blueHub = new Hub(false, 125, 125, 5000, 200, 5);
        
        addObject(redHub, getWidth() / 14, getHeight() / 2);
        addObject(blueHub, getWidth() / 14 * 13, getHeight() / 2);
        
        TroopSpawner redSpawn1 = new TroopSpawner(true, 100, 110, 500, 100, 4);
        TroopSpawner redSpawn2 = new TroopSpawner(true, 100, 110, 500, 100, 4);
        
        addObject(redSpawn1, getWidth() / 9, getHeight() / 4 - 50);
        addObject(redSpawn2, getWidth() / 9, getHeight() / 4 * 3 + 50);
        
        TroopSpawner blueSpawn1 = new TroopSpawner(false, 100, 110, 500, 100, 4);
        TroopSpawner blueSpawn2 = new TroopSpawner(false, 100, 110, 500, 100, 4);
        
        addObject(blueSpawn1, getWidth() / 9 * 8, getHeight() / 4 - 50);
        addObject(blueSpawn2, getWidth() / 9 * 8, getHeight() / 4 * 3 + 50);
        
        redtower1 = new DefenseTower(true, 130, 130, 999, 100, 1);
        redtower2 = new DefenseTower(true, 130, 130, 999, 100, 1);
        bluetower1 = new DefenseTower(false, 130, 130, 999, 100, 1);
        bluetower2 = new DefenseTower(false, 130, 130, 999, 100, 1);
        
        addObject(bluetower1, getWidth() / 4 * 3, getHeight()/2-130);
        addObject(bluetower2, getWidth() / 4 * 3, getHeight()/2+130);
        
        addObject(redtower1, getWidth() / 4, getHeight()/2-130);
        addObject(redtower2, getWidth() / 4, getHeight()/2+130);
        
        
        
    }
    
}
