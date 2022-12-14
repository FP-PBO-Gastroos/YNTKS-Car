import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

abstract public class State {

    abstract public void update(Graphics graphics);
    abstract public void onMousepressed(MouseEvent e);
    abstract public void onKeyPresses(KeyEvent e);

}
