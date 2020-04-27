import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Back extends Button
{
    private World previousWorld; // the world this button should return to when clicked
    
    public Back(World previousWorld)
    {
        this.previousWorld = previousWorld;
        selectedImg = new GreenfootImage("backBtnselected.png");
        unselectedImg = new GreenfootImage("backBtnUnselected.png");
        setImage(unselectedImg);
    }
    
    public void onClick()
    {
        Greenfoot.setWorld(previousWorld);
    }
}
