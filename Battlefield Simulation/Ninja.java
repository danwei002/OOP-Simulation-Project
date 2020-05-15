import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ninja is a troop that has low health, high damage, very high speed
 * 
 * It has the special ability to turn invulnerable when not attacking
 * 
 * @author Stanley Wang
 * @version (a version number or a date)
 */
public class Ninja extends Troops
{
    
    public boolean invulnerability = true;
    
    //
    public Ninja(boolean isRed){
        cooldown = 10;
        cooldownTimer = cooldown;
        this.isRed = isRed;
        maxHp = maxHp_Ninja;
        this.hp = maxHp;
        this.damage = damage_Ninja;
        this.speed = speed_Ninja;
        this.sight = sight_Ninja;
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
    
    protected void march(){
        move(speed);
        invulnerability = true;
        getImage().setTransparency(100);
    }
    
    protected void takeDamage(int damage){
        if(invulnerability){
            return;
        }
        this.hp -= damage;
        healthBar.update(hp);
        if(hp <= 0){
            die();
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
        invulnerability = false;
        getImage().setTransparency(255);
    }
}
