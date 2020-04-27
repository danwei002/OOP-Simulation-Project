import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainMenu is the World that the user will see when
 * they first load into the simulation. From there they can
 * start the simulation or change the simulation parameters.
 * 
 * @author Daniel Wei
 * @version April 27, 2020
 */
public class MainMenu extends World
{
    // Background image
    private GreenfootImage bkgrnd = new GreenfootImage("mainMenu.png");
    
    // Menu music
    public final static GreenfootSound menuMusic = new GreenfootSound("menuMusic.mp3");
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        bkgrnd.scale(960, 640);
        setBackground(bkgrnd);
        
        StartBtn startBtn = new StartBtn();
        addObject(startBtn, getWidth() / 2, getHeight() / 2 - 100);
    }
    
    public void started()
    {
        menuMusic.playLoop();
    }
}
