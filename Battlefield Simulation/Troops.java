
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
    
    // Ninja stats
    protected final int maxHp_Ninja = 50;
    protected final int speed_Ninja = 8;
    protected final int damage_Ninja = 40;
    protected final int sight_Ninja = 125;
    
    // Medic stats
    protected final int maxHp_Medic = 100;
    protected final int speed_Medic = 2;
    protected final int damage_Medic = 20;
    protected final int sight_Medic = 200;
    protected final int healAmount_Medic = 10;
    
    // Tank stats
    protected final int maxHp_Tank = 300;
    protected final int damage_Tank = 15; // change this later
    protected final int speed_Tank = 1;
    protected final int sight_Tank = 135;
    
    protected final int healthBarY = -30;
    
    protected int speed;
    protected int maxHp;
    protected int hp;
    protected int damage;
    
    protected boolean isRed; // If troop is on team red, then statement would be true
    protected int direction;
    
    protected int sight;
    
    protected int cooldown;
    protected int cooldownTimer;
    Building closestBuilding;
    protected TroopHealthBar healthBar;
    public void act() 
    {
    }
    public void addedToWorld(World w){
        createHealthbar();
    }
    protected void createHealthbar(){
        healthBar = new TroopHealthBar(50, 10, 1, hp, maxHp, this, 0, healthBarY);
        getWorld().addObject(healthBar, getX(), getY());
    }
    
    protected void die(){
        getWorld().removeObject(healthBar);
        getWorld().removeObject(this);
    }
    
    protected void changeSight(int newSight){
        sight = newSight;
    }
    
    protected void takeDamage(int damage){
        this.hp -= damage;
        healthBar.update(hp);
        checkDead();
    }
    
    protected void checkDead(){
        if(hp <= 0){
            die();
        }
    }
    
    protected void target(){
        boolean enemyInRange = false;
        List<Troops> troopList = getObjectsInRange(sight, Troops.class);
        
        
        for(Troops t : troopList){
            
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
    
            closestBuilding = getClosestBuilding(getWorld().getObjects(Building.class));
            
            if(closestBuilding != null){
                turnTowards(closestBuilding.getX(), closestBuilding.getY());
                if(distance(closestBuilding, this) <= sight){
                    if(cooldownTimer <= 0){
                        attackEnemy();
                        cooldownTimer = cooldown;
                    }
                }
                else move(speed);
            }
        }
      }
    
    protected Building getClosestBuilding(List<Building> buildings){
        Building closestBuilding = null;
        for(Building b : buildings){
            if(b.getTeam() != getTeam()){
                closestBuilding = b;
                break;
            }
        }
        for(Building b : buildings){
            if(b.getTeam() != getTeam()){
                if(distance(b, this) < distance(closestBuilding, this)){
                    closestBuilding = b;
                }
            }
        }
        return closestBuilding;
    }
    protected static int distance(Actor a, Actor b){
        int xx = a.getX() -b.getX();
        int yy = a.getY() - b.getY();
        
        
        return (int)Math.sqrt(xx*xx +yy*yy);
    }
    
    
    protected boolean getTeam(){
        return isRed;
    }
    public void healMe(int health){
        hp += health;
        if(hp >= maxHp){
            hp = maxHp;
        }
        healthBar.update(hp);
    }
    public int getHp(){
        return hp;
    }
    public int getMaxHp(){
        return maxHp;
    }
    public abstract void attackEnemy();
}
