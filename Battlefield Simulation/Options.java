import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{
    private GreenfootImage bkgrnd = new GreenfootImage("optionsBkgrnd.png");
    /**
     * Constructor for objects of class Options.
     * 
     */
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        bkgrnd.scale(960, 640);
        setBackground(bkgrnd);
        
        BackBtn backBtn = new BackBtn(new MainMenu());
        addObject(backBtn, 140, 50);
    }
}
