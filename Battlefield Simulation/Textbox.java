import greenfoot.*;
import java.util.*;

public class Textbox extends Actor
{
    private static final int MAX_INPUT_WIDTH = 10;
    private static Textbox focusOn;
     
    private String text;
      
    public Textbox()
    {
        text = "";
        updateImage();
    }
      
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(15*MAX_INPUT_WIDTH, 30);
        image.setColor(new Color(0, 0, 0));
        image.fill();
        image.setColor(new Color(211,211,211));
        image.fillRect(3, 3, image.getWidth()-6, 24);
        GreenfootImage textImage = new GreenfootImage(text, 24, null, null);
        image.drawImage(textImage, (image.getWidth()-textImage.getWidth())/2, 15-textImage.getHeight()/2);
        setImage(image);
    }
  
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            while(Greenfoot.getKey() != null);
            focusOn = this;
        }
        
        if (focusOn == this)
        {
            if (Greenfoot.mouseClicked(null) && !Greenfoot.mouseClicked(this))
            {
                focusOn = null;
                return;
            }
            String key = Greenfoot.getKey();
            if (key == null) return;
            if ("enter".equals(key) && text.length() > 0) return;
            if ("backspace".equals(key) && text.length() > 0) text = text.substring(0, text.length() - 1);
            if ("escape".equals(key)) text = "";
            if ("space".equals(key)) key = " ";
            if (key.length() == 1 && text.length() < MAX_INPUT_WIDTH) text += key;
            updateImage();
        }
    }
     
    public String transferValue()
    {
        return text;
    }
}