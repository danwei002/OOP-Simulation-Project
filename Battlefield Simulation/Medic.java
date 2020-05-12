import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Medic here.
 * 
 * @author Howard Yang
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
        }
        else{
            this.setImage("medicB.png");
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
    /**
     * targets allies for healing before acting like a regular troop
     */
    @Override
    protected void target(){
        boolean allyInRange = false;
        
        for(Troops t: getObjectsInRange(sight, Troops.class)){
            if (t.getTeam() == getTeam() && t.getHp() < t.getMaxHp()){//target damaged allies
                allyInRange = true;
                turnTowards(t.getX(),t.getY());
                break;
            }
        }
        
        if(allyInRange){
            if(cooldownTimer <= 0){
                healAlly();
                cooldownTimer = cooldown;
            }
        }
        else super.target();//if no allies in range, attack enemy troops/buildings
    }
    public void attackEnemy(){
        getWorld().addObject(new Bullet(getTeam(),10, getRotation(), damage), getX(), getY());
    }
    public void healAlly(){
       getWorld().addObject(new HealBullet(this, getTeam(),10, getRotation(), healAmount), getX(), getY());
       
    }
}
