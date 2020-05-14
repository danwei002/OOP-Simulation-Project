import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HealBullets are projectiles
 * that heal troops they hit.
 * 
 * @author Howard Yang 
 * @version (a version number or a date)
 */
public class HealBullet extends Projectiles
{
    /**
     * Act - do whatever the HealBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Troops shooter;
    private int healAmount;
    public HealBullet(Troops troop, boolean team, int bulletSpeed,
    int bulletDirection, int healAmount){
        shooter = troop;
        this.team = team;
        speed = bulletSpeed;
        direction = bulletDirection;
        this.healAmount = healAmount;
        setRotation(direction);
    }
    protected void checkCollision()
    {
        Troops t = (Troops) getOneIntersectingObject(Troops.class);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        if(t != null && t != shooter){
            if(t.getTeam() == team && t.getHp() != t.getMaxHp()){
                t.healMe(healAmount);
                getWorld().removeObject(this);
            }
            return;
        }
        
    }
    public void act() 
    {
        // Add your action code here.
        move(speed);
        checkCollision();
    }    
}
