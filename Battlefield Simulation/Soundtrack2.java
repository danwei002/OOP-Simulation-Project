import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soundtrack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack2 extends Actor
{
    private GreenfootImage selectedImg = new GreenfootImage("sTrack2selected.png");
    private GreenfootImage unselectedImg = new GreenfootImage("sTrack2Unselected.png");
    /**
     * Act - do whatever the Soundtrack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soundtrack2()
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
            List<Soundtrack2> btn = (List<Soundtrack2>) getWorld().getObjectsAt(x, y, Soundtrack2.class);
            
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
            Battleground.selectedTrack = MusicSelect.battleMusic2;
            World w = new Battleground();
            Greenfoot.setWorld(w);
        }
    }      
}
