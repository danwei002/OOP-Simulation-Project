import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Battleground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battleground extends World
{
    // Some constants for building locations
    
    // Red Barracks/troop spawners
    public static final int RED_BARRACK_X = 960 / 9;
    public static final int RED_BARRACK_1_Y = 110;
    public static final int RED_BARRACK_2_Y = 530;
    
    // Red Defense Towers
    public static final int RED_DEF_X = 240;
    public static final int RED_DEF_1_Y = 190;
    public static final int RED_DEF_2_Y = 450;
    
    // Red Artilleries
    public static final int RED_ART_X = 400;
    public static final int RED_ART_OFFSET = 120;
    
    // Blue Barracks/troop spawners
    public static final int BLUE_BARRACK_X = 960 / 9 * 8;
    public static final int BLUE_BARRACK_1_Y = 110;
    public static final int BLUE_BARRACK_2_Y = 530;
    
    // Blue Defense Towers
    public static final int BLUE_DEF_X = 720;
    public static final int BLUE_DEF_1_Y = 190;
    public static final int BLUE_DEF_2_Y = 450;
    
    // Blue Artilleries
    public static final int BLUE_ART_X = 560;
    public static final int BLUE_ART_OFFSET = 120;
    
    // Battle music
    public static GreenfootSound selectedTrack; // This needs to be public so that other classes (the buttons) can set it
    
    // Variables for simulation changes by the user
    public static int RED_HUB_HP = 5000;
    public static int RED_HUB_CHARGE_DELAY = 5;
    
    public static int BLUE_HUB_HP = 5000;
    public static int BLUE_HUB_CHARGE_DELAY = 5;
    
    /**
     * Constructor for objects of class Battleground.
     * 
     */
    TroopSpawner red,blue;
    DefenseTower redtower1,redtower2,bluetower1,bluetower2;
    public Battleground()
    {    
        super(960, 640, 1);
        MainMenu.menuMusic.stop();
        GreenfootImage background = new GreenfootImage("background.jpeg");
        setBackground(background);
        
        // Hub spawn locations?
        Hub redHub = new Hub(true, 125, 125, RED_HUB_HP, 200, RED_HUB_CHARGE_DELAY);
        Hub blueHub = new Hub(false, 125, 125, BLUE_HUB_HP, 200, BLUE_HUB_CHARGE_DELAY);
        
        addObject(redHub, getWidth() / 14, getHeight() / 2);
        addObject(blueHub, getWidth() / 14 * 13, getHeight() / 2);
        
        TroopSpawner redSpawn1 = new TroopSpawner(true, 100, 110, 500, 100, 2);
        TroopSpawner redSpawn2 = new TroopSpawner(true, 100, 110, 500, 100, 2);
        
        addObject(redSpawn1, RED_BARRACK_X, RED_BARRACK_1_Y);
        addObject(redSpawn2, RED_BARRACK_X, RED_BARRACK_2_Y);
        
        TroopSpawner blueSpawn1 = new TroopSpawner(false, 100, 110, 500, 100, 2);
        TroopSpawner blueSpawn2 = new TroopSpawner(false, 100, 110, 500, 100, 2);
        
        addObject(blueSpawn1, BLUE_BARRACK_X, BLUE_BARRACK_1_Y);
        addObject(blueSpawn2, BLUE_BARRACK_X, BLUE_BARRACK_2_Y);
        
        redtower1 = new DefenseTower(true, 130, 130, 999, 100, 1);
        redtower2 = new DefenseTower(true, 130, 130, 999, 100, 1);
        bluetower1 = new DefenseTower(false, 130, 130, 999, 100, 1);
        bluetower2 = new DefenseTower(false, 130, 130, 999, 100, 1);
        
        addObject(redtower1, RED_DEF_X, RED_DEF_1_Y);
        addObject(redtower2, RED_DEF_X, RED_DEF_2_Y);
        
        addObject(bluetower1, BLUE_DEF_X, BLUE_DEF_1_Y);
        addObject(bluetower2, BLUE_DEF_X, BLUE_DEF_2_Y);
        
        selectedTrack.setVolume(69);
        selectedTrack.playLoop();
    }
    
    public void started()
    {
        
    }
}
