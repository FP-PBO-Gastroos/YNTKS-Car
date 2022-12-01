import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class MenuState extends State {
    private  int count=0;
    @Override
    public void update(Graphics graphics) {

        if (count==0) {
            Resources.mainMenuTone.loop();
            Resources.gameOverTone.stop();
            Resources.welcomeTone.stop();
            count++;
        }


        graphics.drawImage(Resources.welcomeToGameImage,0,0,400,700,null);
        graphics.setColor(Color.RED);
        graphics.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
       // graphics.drawString("YNTKS-CAR",50,270);
        graphics.drawString("YNTKS-CAR",62,320);
        graphics.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        graphics.setColor(Color.WHITE);
        graphics.drawString("START GAME",110,375);
        graphics.drawString("EXIT",160,425);

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r1 =  new Rectangle(175,400,65,25);
        Rectangle r2 =  new Rectangle(110,350,195,25);
        if(r1.contains(e.getX(),e.getY()))
        {
            Demo.frame.dispatchEvent(new WindowEvent(Demo.frame, WindowEvent.WINDOW_CLOSING));
        }
        else if (r2.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new WelcomeToStage1();
        }


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
