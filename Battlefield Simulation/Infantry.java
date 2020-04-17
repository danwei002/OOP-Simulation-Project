import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    
    
    private boolean targetingEnemy;
    
    public Infantry(boolean isRed){
        cooldown = 25;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        maxHp = maxHp_Infantry;
        this.hp = maxHp;
        this.damage = damage_Infantry;
        this.speed = speed_Infantry;
        this.sight = sight_Infantry;
        if(isRed == true){
            this.setImage("infantryR.png");
            direction = 0;
        }
        else{
            this.setImage("infantryB.png");
            direction = 180;
        }
    }
    public Infantry(boolean isRed, int hp, int speed, int damage, int sight){
        cooldown = 25;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        maxHp = hp;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.sight = sight;
        
        if(isRed == true){
            this.setImage("infantryR.png");
            direction = 0;
        }
        else{
            this.setImage("infantryB.png");
            direction = 180;
        }
    }
    
    // if troops are spawned in with less than max hp, for example being revived
    public Infantry(boolean isRed, int hp, int maxHp, int speed, int damage, int sight){
        cooldown = 25;
        cooldownTimer = cooldown;
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
        target();
        if(cooldownTimer > 0){
            cooldownTimer--;
        }
    }
    
    public void attackEnemy(){
        getWorld().addObject(new Bullet(getTeam(),10, getRotation(), damage), getX(), getY());
    }

}
