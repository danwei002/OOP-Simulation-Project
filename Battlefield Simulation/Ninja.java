import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ninja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ninja extends Troops
{
    //
    public Ninja(boolean isRed){
        cooldown = 10;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        maxHp = maxHp_Infantry;
        this.hp = maxHp;
        this.damage = damage_Infantry;
        this.speed = speed_Infantry;
        this.sight = sight_Infantry;
        if(isRed == true){
            this.setImage("ninjaR.png");
            direction = 0;
        }
        else{
            this.setImage("ninjaB.png");
            direction = 180;
        }
    }
    
    //
    public Ninja(boolean isRed, int hp, int speed, int damage, int sight){
        cooldown = 10;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        maxHp = hp;
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.sight = sight;
        
        if(isRed == true){
            this.setImage("ninjaR.png");
            direction = 0;
        }
        else{
            this.setImage("ninjaB.png");
            direction = 180;
        }
    }
    
    //
    public Ninja(boolean isRed, int hp, int maxHp, int speed, int damage, int sight){
        cooldown = 10;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        this.maxHp = maxHp;
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.sight = sight;
        
        if(isRed == true){
            this.setImage("ninjaR.png");
            direction = 0;
        }
        else{
            this.setImage("ninjaB.png");
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
        getWorld().addObject(new Bullet(getTeam(),15, getRotation(), damage, "ninjaStar.png"), getX(), getY());
    }
}
