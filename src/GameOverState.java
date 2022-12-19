import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameOverState extends State {
    private Object[] options = {"MAIN LAGI",
            "KELUAR",};
    private int n;
    @Override
    public void update(Graphics graphics)
    {


        Resources.carMoving.stop();
        Resources.gameOverTone.loop();

        n = JOptionPane.showOptionDialog(Demo.frame,
                "YO NDAK TAU KOK TANYA SAYA..",
                "KOK KALAH SIH??!!",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,null,
                options,
                options[1]);

        if (n==0)
            GamePanel.currentState= new MenuState();
        else
            System.exit(0);
    }

    @Override
    public void onMousepressed(MouseEvent e) {


    }

    @Override
    public void onKeyPresses(KeyEvent e) {

    }
}
