import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    protected int speed;
    protected int maxHp;
    protected int hp;
    protected int damage;
    
    protected boolean isRed; // If troop is on team red, then statement would be true
    protected int direction;
    
    protected int sight;
    
    public void act() 
    {
        
    }
    
    protected void die(){
        getWorld().removeObject(this);
    }
    
    protected void changeSight(int newSight){
        sight = newSight;
    }
    public void takeDamage(int damage){
        this.hp -= damage;
        checkDead();
    }
    public void checkDead(){
        if(hp <= 0){
            getWorld().removeObject(this);
        }
    }
    public abstract void march();
    public abstract void target();
    public abstract boolean getTeam();
    public abstract void attackEnemy();
}
