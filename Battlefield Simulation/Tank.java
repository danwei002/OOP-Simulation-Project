import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tank extends Troops
{
    private int maxHp_Tank = 300;
    private int damage_Tank = 15; // change this later
    private int speed_Tank = 1;
    private int sight_Tank = 135;
    
    /**
     * Act - do whatever the Tank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Tank(boolean isRed){
        cooldownTimer = 70;
        cooldown = cooldownTimer;
        this.isRed = isRed;
        maxHp = maxHp_Tank;
        this.hp = maxHp_Tank;
        this.damage = damage_Tank;
        this.speed = speed_Tank;
        this.sight = sight_Tank;
        if(isRed == true){
            this.setImage("TANKR.png");
            direction = 0;
        }
        else{
            this.setImage("TANKB.png");
            direction = 180;
        }
    }
    
    public Tank(boolean isRed, int hp, int maxHp, int speed, int damage, int sight){
        cooldownTimer = 70;
        cooldown = cooldownTimer;
        this.isRed = isRed;
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.damage = damage;
        this.sight = sight;
        if(isRed == true){
            this.setImage("TANKR.png");
            direction = 0;
        }
        else{
            this.setImage("TANKB.png");
            direction = 180;
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
