import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Infantry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Infantry extends Troops
{
    /**
     * Act - do whatever the Infantry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Infantry(boolean isRed, int hp, int speed, int damage, int sight){
        this.isRed = isRed;
        maxHp = hp;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.sight = sight;
        
        if(isRed == true){
            //this.setImage("red soldier");
            //direction = up;
        }
        else{
            //this.setImage("blue soldier");
            //direction = down;
        }
    }
    
    // if troops are spawned in with less than max hp, for example being revived
    public Infantry(boolean isRed, int hp, int maxHp, int speed, int damage, int sight){
        this.isRed = isRed;
        this.maxHp = maxHp;
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.sight = sight;
        
        if(isRed == true){
            //this.setImage("red soldier");
            //direction = up;
        }
        else{
            //this.setImage("blue soldier");
            //direction = down;
        }
    }
    
    public void act() 
    {
        march();
    }
    
    public void march(){
        this.setRotation(direction);
        move(2);
    }
    
    public void target(){
        
    }
    
    public boolean getTeam(){
        return isRed;
    }
}
