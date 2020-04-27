import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Soundtrack1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soundtrack1 extends Button
{
    /**
     * Act - do whatever the Soundtrack1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Soundtrack1()
    {
        selectedImg = new GreenfootImage("sTrack1selected.png");
        unselectedImg = new GreenfootImage("sTrack1Unselected.png");
        setImage(unselectedImg);
    }
 
    public void onClick()
    {
        Battleground.selectedTrack = MusicSelect.battleMusic1;
        World w = new Battleground();
        Greenfoot.setWorld(w);
    }
}
