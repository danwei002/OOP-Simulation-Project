import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    List<Troops> targetList;
    
    private boolean targetingEnemy;
    
    private int cooldown = 25;
    private int cooldownTimer = cooldown;
    public Infantry(boolean isRed){
        this(isRed, 100, 5, 5, 100);
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
            direction = 90;
        }
        else{
            this.setImage("infantryB.png");
            direction = 270;
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
        move(2);
    }
    
    public void attackEnemy(){
        getWorld().addObject(new Bullet(20, getRotation(), damage), getX(), getY());
    }
    
    public void target(){
        boolean enemyInRange = false;
        targetList = getObjectsInRange(sight, Troops.class);
        if(targetList.size() > 0){
         
            for(Troops t : targetList){
            
                if(t.getTeam() != getTeam()){
                    turnTowards(t.getX(), t.getY());
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
