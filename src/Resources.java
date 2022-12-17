import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

    public class Resources {
    public static Image playerCar;
    public static Image enemyCar1;
    public static Image enemyCar2;
    public static Image enemyCar3;
    public static Image death;
    public static Image roadImage;
    public static Image crashBoomImage;
    public static Image finishLineImage;
    public static Image playPause;
    public static Image completeGame;

    public static Image welcomeStageImage;
    public static Image welcomeToGameImage;
    public static AudioClip carCrash;
    public static AudioClip carMoving;
    public static AudioClip mainMenuTone;
    public static AudioClip welcomeTone;
    public static AudioClip gameOverTone;
    public static AudioClip finishTone;

    private Resources()
    {

    }

    public static void loadResources() {
        try {

            playerCar = ImageIO.read(Resources.class.getResource("Images/playerCar.png"));
            enemyCar1 = ImageIO.read(Resources.class.getResource("Images/enemyCar1.png"));
            enemyCar2 = ImageIO.read(Resources.class.getResource("Images/enemyCar2.png"));
            enemyCar3 = ImageIO.read(Resources.class.getResource("Images/enemyCar3.png"));
            playPause = ImageIO.read(Resources.class.getResource("Images/playpause.jpg"));
            death = ImageIO.read(Resources.class.getResource("Images/death.png"));
            welcomeToGameImage = ImageIO.read(Resources.class.getResource("Images/menubg.jpg"));
            welcomeStageImage = ImageIO.read(Resources.class.getResource("Images/menubg.jpg"));
            finishLineImage = ImageIO.read(Resources.class.getResource("Images/finishLine.png"));
            crashBoomImage = ImageIO.read(Resources.class.getResource("Images/crash.png"));
            roadImage = ImageIO.read(Resources.class.getResource("Images/Road.png"));
            completeGame = ImageIO.read(Resources.class.getResource("Images/Completegame.png"));
            carCrash= Applet.newAudioClip(Resources.class.getResource("AudioClips/carcrash.wav"));
            carMoving= Applet.newAudioClip(Resources.class.getResource("AudioClips/carSound.wav"));
            mainMenuTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/backSongMenu.wav"));
            welcomeTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/backSongWelcome.wav"));
            gameOverTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/gameover.wav"));
            finishTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/finish.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
