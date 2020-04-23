import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Medic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medic extends Troops
{
    /**
     * Act - do whatever the Medic wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int healAmount;
    public Medic(boolean isRed){
        this.isRed = isRed;
        cooldown = 25;
        cooldownTimer = cooldown;
        maxHp = maxHp_Medic;
        this.hp = maxHp;
        this.damage = damage_Medic;
        this.speed = speed_Medic;
        this.sight = sight_Medic;
        this.healAmount = healAmount_Medic;
        if(isRed == true){
            this.setImage("medicR.png");
            direction = 0;
        }
        else{
            this.setImage("medicB.png");
            direction = 180;
        }
    }
    public void act() 
    {
        // Add your action code here.
        target();
        if(cooldownTimer > 0){
            cooldownTimer--;
        }
    }    
    protected void target(){
        boolean enemyInRange = false, allyInRange = false;
        List<Troops> troopList = getObjectsInRange(sight, Troops.class);
        List<Building> buildingList = getObjectsInRange(sight, Building.class);
        
        int targetListSize = troopList.size() + buildingList.size();
        if(targetListSize > 0){
        for(Building b : buildingList){
            if(b.getTeam() != getTeam()){
                turnTowards(b.getX(), b.getY());
                enemyInRange = true;
            }
        } 
        for(Troops t : troopList){
            
            if(t.getTeam() != getTeam()){
                turnTowards(t.getX(), t.getY());
                enemyInRange = true;
            }else if (t.getHp() != t.getMaxHp() && t.getTeam() == getTeam()){
                turnTowards(t.getX(), t.getY());
                allyInRange = true;
                break;
            }
        }
        
        if(allyInRange){
           if(cooldownTimer <= 0){
                healAlly();
                cooldownTimer = cooldown;
            } 
        }
        else if(enemyInRange){
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
    public void attackEnemy(){
        getWorld().addObject(new Bullet(getTeam(),10, getRotation(), damage), getX(), getY());
    }
    public void healAlly(){
       getWorld().addObject(new HealBullet(this, getTeam(),10, getRotation(), healAmount), getX(), getY());
       
    }
}
