import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kontrol extends State{
    private int count=0;

    @Override
    public void update(Graphics graphics) {

        graphics.drawImage(Resources.kontrol,0,0,400,700,null);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,24));

        if (count==0) {
            Resources.mainMenuTone.stop();
            Resources.welcomeTone.loop();
            count++;
        }

        graphics.drawString("KEMBALI", 300, 40);

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Rectangle r = new Rectangle(290,10,130,40);
        if (r.contains(e.getX(),e.getY()))
        {
            GamePanel.currentState= new MenuState();
        }


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
