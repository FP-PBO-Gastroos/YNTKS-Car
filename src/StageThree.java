import java.awt.*;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.*;

public class StageThree extends State {
    private Road road = new Road(12);
    private Car car = new Car();
    private FinalLine finalLine = new FinalLine(12, -8000);
    private enemy1 enemy11 = new enemy1(-750, 15);
    private enemy1 enemy12 = new enemy1(-1450, 15);
    private enemy2 enemy21 = new enemy2(-400, 15);
    private enemy2 enemy22 = new enemy2(-1100, 15);
    private enemy3 enemy31 = new enemy3(-1700, 15);
//    private enemy22 car3 = new enemy22(-1250, 15);
    private Death death = new Death(-800, 12);
    private int count = 0;
    private java.util.List<Elements> list = new ArrayList<>();
    private java.util.List<enemy1> enemy1ArrayList = new ArrayList<>();
    private java.util.List<enemy2> enemy2ArrayList = new ArrayList<>();
    private java.util.List<enemy3> enemy3ArrayList = new ArrayList<>();
    private boolean finishStage = false;
    private int time = 100;

    @Override
    public void update(Graphics graphics) {

        if (count == 0) {
            Resources.welcomeTone.stop();
            Resources.mainMenuTone.stop();
            Resources.carMoving.loop();
        }
        list.clear();
        enemy1ArrayList.clear();
        enemy2ArrayList.clear();
        enemy3ArrayList.clear();
        enemy1ArrayList.add(enemy11);
        enemy1ArrayList.add(enemy12);
        enemy2ArrayList.add(enemy21);
        enemy2ArrayList.add(enemy22);
        enemy3ArrayList.add(enemy31);
//        enemy3ArrayList.add(car3);
        list.addAll(enemy1ArrayList);
        list.addAll(enemy2ArrayList);
        list.addAll(enemy3ArrayList);
        list.add(death);
        count++;

        //CODE TO REDUCE TIME
        if (count % 10 == 0 && !finishStage)
            time--;

        //CODE TO CHECK INTERSECTION OF CAR WITH deathOR TRUCK OR TIMES UP
        if (finishStage == false && (death.checkIntersection(car)  || time < 0)) {
            for (int i = 0; i < 1000; i++) {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }

            GamePanel.currentState = new GameOverState();
        }

        //CODE CHECK WHEATHER CAR REACHED FINISH LINE OR NOT
        if (finalLine.checkIntersection(car)) {
            finishStage = true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel = 0;
            for (int i = 0; i < list.size(); i++) {

                list.get(i).hidden = true;
                list.get(i).yvel = 0;

            }
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;

        }

        //CODE TO MOVE TO NEXT STATE
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToStage4();

        //CODE TO CHECK INTERSECTION OF OTHER ELEMENTS WITH deathS
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).checkIntersection(death) && !(list.get(i) instanceof Death))
                list.get(i).hidden = true;
        }
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);
        graphics.drawImage(Resources.finishLineImage, finalLine.x, finalLine.y, null);
        graphics.drawImage(Resources.playerCar, car.x, car.y, null);
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("STAGE - 3", 260, 30);

        //CODE TO DISPLAY TIME
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
            graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
        }

        //CODE  TO DISPLAY RED CARS
        for (int i = 0; i < enemy1ArrayList.size(); i++)
            if (!enemy1ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar1, enemy1ArrayList.get(i).x, enemy1ArrayList.get(i).y, null);

      //CODE TO DISPLAY WHITE CARS
        for (int i = 0; i < enemy2ArrayList.size(); i++)
            if (!enemy2ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar2, enemy2ArrayList.get(i).x, enemy2ArrayList.get(i).y, null);

      //CODE TO DISPLAY WHITE CARS
        for (int i = 0; i < enemy3ArrayList.size(); i++)
            if (!enemy3ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar3, enemy3ArrayList.get(i).x, enemy3ArrayList.get(i).y, null);

        //CODE TO DISPLAY death
        if (!death.hidden)
            graphics.drawImage(Resources.death, death.x, death.y, null);
        
        //CODE TO CHECK INTERSECTION OF CAR WITH OTHER ELEMENTS
        for (int i = 0; i < list.size(); i++)
        {
            if (!list.get(i).hidden && list.get(i).checkIntersection(car)) {
                if (!finishStage && list.get(i) instanceof Death) {
                    GamePanel.currentState = new GameOverState();
                }
                 else {
                    time -= 10;
                    list.get(i).hidden = true;
                }
                Resources.carCrash.play();
                for (int j = 0; j < 1000; j++) {
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
                }
            }
        }

        //CODE TO UPDATE POSITION OF EVERY ELEMENT
        road.updatePos();
        car.updatePos();
//        truck1.updatePos();
        finalLine.updatePos();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).updatePos();
        }

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);

    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e, car);
    }
}
