import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Button
{
    public Start()
    {
        selectedImg = new GreenfootImage("startBtnselected.png");
        unselectedImg = new GreenfootImage("startBtnUnselected.png");
        setImage(unselectedImg);
    }
    
    public void onClick()
    {
        World w = new MusicSelect();
        Greenfoot.setWorld(w);
    }
}
