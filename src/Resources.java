import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.IOException;

    public class Resources {
    public static Image carImage;
    public static Image redCarImage;
    public static Image roadImage;
    public static Image baricadeImage;
    public static Image newCarImage;
    public static Image newCar2;
    public static Image crashBoomImage;
    public static Image finishLineImage;
    public static Image congImage;
    public static Image playPause;

    public static Image welcomeStageImage;
    public static Image welcomeToGameImage;
    public static AudioClip carCrash;
    public static AudioClip carMoving;
    public static AudioClip mainMenuTone;
    public static AudioClip welcomeTone;
    public static AudioClip gameOverTone;
    public static AudioClip finishTone;
    public static AudioClip truckTone;

    private Resources()
    {

    }

    public static void loadResources() {
        try {

            carImage = ImageIO.read(Resources.class.getResource("Images/playerCar.png"));
            redCarImage = ImageIO.read(Resources.class.getResource("Images/enemyCar1.png"));
            newCarImage = ImageIO.read(Resources.class.getResource("Images/enemyCar2.png"));
            newCar2 = ImageIO.read(Resources.class.getResource("Images/Car4.png"));
            baricadeImage = ImageIO.read(Resources.class.getResource("Images/death.png"));
            playPause = ImageIO.read(Resources.class.getResource("Images/playpause.jpg"));
            welcomeToGameImage = ImageIO.read(Resources.class.getResource("Images/menubg.jpg"));
            welcomeStageImage = ImageIO.read(Resources.class.getResource("Images/menubg.jpg"));
            congImage = ImageIO.read(Resources.class.getResource("Images/com.jpg"));
            finishLineImage = ImageIO.read(Resources.class.getResource("Images/finishLine.png"));
            crashBoomImage = ImageIO.read(Resources.class.getResource("Images/crash.png"));
            roadImage = ImageIO.read(Resources.class.getResource("Images/road1.jpg"));
            carCrash= Applet.newAudioClip(Resources.class.getResource("AudioClips/carcrash.wav"));
            carMoving= Applet.newAudioClip(Resources.class.getResource("AudioClips/carSound.wav"));
            mainMenuTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/backSongMenu.wav"));
            welcomeTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/backSongWelcome.wav"));
            gameOverTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/gameover.wav"));
            finishTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/finish.wav"));
            truckTone= Applet.newAudioClip(Resources.class.getResource("AudioClips/truckAudio.wav"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
