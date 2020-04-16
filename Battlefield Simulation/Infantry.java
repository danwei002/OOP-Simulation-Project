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
    
    private int cooldown = 25;
    private int cooldownTimer = cooldown;
    public Infantry(boolean isRed){
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
    
    
    public void march(){
        this.setRotation(direction);
        move(speed);
    }
    
    public void attackEnemy(){
        getWorld().addObject(new Bullet(getTeam(),10, getRotation(), damage), getX(), getY());
    }
    
    
    
    public void target(){
        boolean enemyInRange = false;
        List<Troops> troopList = getObjectsInRange(sight, Troops.class);
        List<Building> buildingList = getObjectsInRange(sight, Building.class);
        
        int targetListSize = troopList.size() + buildingList.size();
        if(targetListSize > 0){
         
            for(Troops t : troopList){
            
                if(t.getTeam() != getTeam()){
                    turnTowards(t.getX(), t.getY());
                    enemyInRange = true;
                }
            }
            for(Building b : buildingList){
            
                if(b.getTeam() != getTeam()){
                    turnTowards(b.getX(), b.getY());
                    enemyInRange = true;
                }
            }
            if(enemyInRange){
                if(cooldownTimer <= 0){
                    attackEnemy();
                    cooldownTimer = cooldown;
                }
            }
            else{
                march();//fix later
            }
        }
        else{
            march();
        }
        
    }
    
    
    public boolean getTeam(){
        return isRed;
    }
}
