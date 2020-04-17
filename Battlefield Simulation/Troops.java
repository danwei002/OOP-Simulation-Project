import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * lol this a troop
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Troops extends Actor
{
    /**
     * Act - do whatever the Troops wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected final int maxHp_Infantry = 100;
    protected final int speed_Infantry = 2;
    protected final int damage_Infantry = 20;
    protected final int sight_Infantry = 200;
    
    protected final int maxHp_Ninja = 50;
    protected final int speed_Ninja = 8;
    protected final int damage_Ninja = 40;
    protected final int sight_Ninja = 125;
    
    //medic stats
    protected final int maxHp_Medic = 100;
    protected final int speed_Medic = 2;
    protected final int damage_Medic = 20;
    protected final int sight_Medic = 200;
    protected final int healAmount_Medic = 20;
    
    protected int speed;
    protected int maxHp;
    protected int hp;
    protected int damage;
    
    protected boolean isRed; // If troop is on team red, then statement would be true
    protected int direction;
    
    protected int sight;
    
    protected int cooldown;
    protected int cooldownTimer;
    
    public void act() 
    {
        
    }
    
    protected void die(){
        getWorld().removeObject(this);
    }
    
    protected void changeSight(int newSight){
        sight = newSight;
    }
    
    protected void takeDamage(int damage){
        this.hp -= damage;
        checkDead();
    }
    
    protected void checkDead(){
        if(hp <= 0){
            getWorld().removeObject(this);
        }
    }
    
    protected void target(){
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
    
    protected void march(){
        this.setRotation(direction);
        move(speed);
    }
    
    protected boolean getTeam(){
        return isRed;
    }
    public void healMe(int health){
        hp += health;
        if(hp >= maxHp){
            hp = maxHp;
        }
    }
    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public abstract void attackEnemy();
}
