import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soundtrack3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack3 extends Button
{
    /**
     * Act - do whatever the Soundtrack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soundtrack3()
    {
        selectedImg = new GreenfootImage("sTrack3selected.png");
        unselectedImg = new GreenfootImage("sTrack3Unselected.png");
        setImage(unselectedImg);
    }
    
    public void onClick()
    {
        Battleground.selectedTrack = MusicSelect.battleMusic3;
        World w = new Battleground();
        Greenfoot.setWorld(w);
    }
}
