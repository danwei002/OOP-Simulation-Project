import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Button extends Actor
{
    protected GreenfootImage selectedImg;
    protected GreenfootImage unselectedImg;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hoverCheck();
        
        if (Greenfoot.mouseClicked(this))
        {
            onClick();
        }
    }    
    
    /**
     * Checks if the cursor is hovering over the button
     * and changes image accordingly
     */
    protected void hoverCheck()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if (mouse != null)
        {
            int x = mouse.getX();
            int y = mouse.getY();
            List<Button> btn = (List<Button>) getWorld().getObjectsAt(x, y, Button.class);
            
            if (btn.size() > 0 && btn.get(0) == this)
            {
                setImage(selectedImg);
            }
            else
            {
                setImage(unselectedImg);
            }
        }
    }
    
    public abstract void onClick();
}
