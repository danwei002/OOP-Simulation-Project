import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soundtrack1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack1 extends Actor
{
    private GreenfootImage selectedImg = new GreenfootImage("sTrack1selected.png");
    private GreenfootImage unselectedImg = new GreenfootImage("sTrack1Unselected.png");
    /**
     * Act - do whatever the Soundtrack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soundtrack1()
    {
        setImage(unselectedImg);
    }
    
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null)
        {
            int x = mouse.getX();
            int y = mouse.getY();
            List<Soundtrack1> btn = (List<Soundtrack1>) getWorld().getObjectsAt(x, y, Soundtrack1.class);
            
            if (btn.size() > 0 && btn.get(0) == this)
            {
                setImage(selectedImg);
            }
            else
            {
                setImage(unselectedImg);
            }
            
        }
        
        if (Greenfoot.mouseClicked(this))
        {
            Battleground.selectedTrack = MusicSelect.battleMusic1;
            World w = new Battleground();
            Greenfoot.setWorld(w);
        }
    }    
}
