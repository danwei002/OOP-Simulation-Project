import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
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
        
        Start startBtn = new Start();
        addObject(startBtn, getWidth() / 2, getHeight() / 2 - 100);
    }
    
    public void started()
    {
        menuMusic.playLoop();
    }
}
