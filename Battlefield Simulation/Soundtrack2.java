import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soundtrack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack2 extends Button
{
    /**
     * Act - do whatever the Soundtrack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soundtrack2()
    {
        selectedImg = new GreenfootImage("sTrack2selected.png");
        unselectedImg = new GreenfootImage("sTrack2Unselected.png");
        setImage(unselectedImg);
    }
    
    public void onClick()
    {
        Battleground.selectedTrack = MusicSelect.battleMusic2;
        World w = new Battleground();
        Greenfoot.setWorld(w);
    }
}
