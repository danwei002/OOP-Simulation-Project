import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicSelect extends World
{
    private GreenfootImage bkgrnd = new GreenfootImage("music select.png");
    
    // Song choices
    public final static GreenfootSound battleMusic1 = new GreenfootSound("battleMusic1.mp3");
    public final static GreenfootSound battleMusic2 = new GreenfootSound("battleMusic2.mp3");
    public final static GreenfootSound battleMusic3 = new GreenfootSound("battleMusic3.mp3");
    

    /**
     * Constructor for objects of class MusicSelect.
     * 
     */
    public MusicSelect()
    {    
        super(960, 640, 1); 
        bkgrnd.scale(960, 640);
        setBackground(bkgrnd);
        
        Soundtrack1 btn1 = new Soundtrack1();
        addObject(btn1, getWidth() / 2, getHeight() / 2 - 100);
        
        Soundtrack2 btn2 = new Soundtrack2();
        addObject(btn2, getWidth() / 2, getHeight() / 2 + 40);
        
        Soundtrack3 btn3 = new Soundtrack3();
        addObject(btn3, getWidth() / 2, getHeight() / 2 + 180);
    }
}
