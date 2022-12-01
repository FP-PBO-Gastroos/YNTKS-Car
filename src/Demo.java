import javax.swing.*;

public class Demo {
    public static JFrame frame;

    public static void main(String[] args) {
        frame =  new JFrame("YNTKS Car");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        GamePanel panel = new GamePanel();
        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


    }
}
