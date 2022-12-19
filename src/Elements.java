import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

 abstract public class Elements {
    public int x = 0;
    public int y = 0;
    public int xVel = 0;
    public int yvel = 0;
    public int height = 0;
    public int width = 0;
    public boolean hidden = false;
    private Random random = new Random();
    
    public void updatePos() {
        this.x += this.xVel;
        this.y += this.yvel;
        this.checkBound();

    }

    abstract public void checkBound();


    public boolean checkIntersection(Elements e) {
        Rectangle r1 = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle r2 = new Rectangle(e.x, e.y, e.width, e.height);

        if (r1.intersects(r2))
            return true;
        else
            return false;
    }

    public void setXRandom(int low, int high) {
        this.x = random.nextInt(high - low) + low;
    }

    public void setYRandom(int low, int high) {
        this.y = -random.nextInt(-high - low) - low;
    }

    public static void pause(MouseEvent e) {
        Rectangle r = new Rectangle(355, 20, 40, 35);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.pause = !GamePanel.pause;
        }
        if (GamePanel.pause) {
            Resources.carMoving.stop();
            Resources.welcomeTone.loop();
        } else {
            Resources.carMoving.loop();
            Resources.welcomeTone.stop();
        }
    }
    
    public static void muteUnmute(MouseEvent e) {
        Rectangle r = new Rectangle(355, 60, 40, 35);
        if (r.contains(e.getX(), e.getY())) {
            GamePanel.muteUnmute = !GamePanel.muteUnmute;
        }
        if (GamePanel.muteUnmute) {
            // Stop all audio except when the game is paused
            if (!GamePanel.pause) {
                Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
            else {
            	Resources.carMoving.stop();
                Resources.welcomeTone.stop();
            }
        } else {
            // Restart audio only if the game is not paused
            if (!GamePanel.pause) {
                Resources.carMoving.loop();
                Resources.welcomeTone.stop();
            }
        }
    }

   
    public static void carHandling(KeyEvent e , Car car) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            car.xVel = 7;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            car.xVel = -7;
        }  else if (e.getKeyCode() == KeyEvent.VK_UP) {
            car.yvel = -3;
        }  else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            car.yvel = 3;
        }  else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            car.xVel = 0;
        }  else if (e.getKeyCode() == KeyEvent.VK_SHIFT)
        	car.yvel = 0;
    }


}


