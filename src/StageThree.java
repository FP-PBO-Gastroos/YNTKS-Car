import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
    private Death death1 = new Death(-600, 10);
    private Death death2 = new Death(-300, 20);
    private int count = 0;
    private List<Elements> list = new ArrayList<>();
    private List<enemy1> enemy1ArrayList = new ArrayList<>();
    private List<enemy2> enemy2ArrayList = new ArrayList<>();
    private List<enemy3> enemy3ArrayList = new ArrayList<>();
    public  List<Death> DeathList = new ArrayList<>();
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
        DeathList.clear();
        enemy1ArrayList.add(enemy11);
        enemy1ArrayList.add(enemy12);
        enemy2ArrayList.add(enemy21);
        enemy2ArrayList.add(enemy22);
        enemy3ArrayList.add(enemy31);
//        enemy3ArrayList.add(car3);
        DeathList.add(death1);
        DeathList.add(death2);
        list.addAll(enemy1ArrayList);
        list.addAll(enemy2ArrayList);
        list.addAll(enemy3ArrayList);
        list.addAll(DeathList);
        count++;

        //CODE TO REDUCE TIME
        if (count % 10 == 0 && !finishStage)
            time--;

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
            for (int i = 0; i < DeathList.size(); i++) {
            	DeathList.get(i).yvel = 0;
                DeathList.get(i).hidden = true;
            }
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;

        }

        //CODE TO MOVE TO NEXT STATE
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToStage4();

        //CODE TO CHECK INTERSECTION OF CAR WITH DEATH
        for (int i = 0; i < DeathList.size(); i++) {
            if ((DeathList.get(i).hidden == false && car.checkIntersection(DeathList.get(i)) && !finishStage )) {
                DeathList.get(i).hidden = true;
                Resources.carCrash.play();

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
              
                GamePanel.currentState = new GameOverState();
            }
            else if (time < 0) {
            	GamePanel.currentState = new GameOverState();
            }

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

        //CODE  TO DISPLAY ENEMY CARS 1
        for (int i = 0; i < enemy1ArrayList.size(); i++)
            if (!enemy1ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar1, enemy1ArrayList.get(i).x, enemy1ArrayList.get(i).y, null);

      //CODE TO DISPLAY ENEMY CARS 2
        for (int i = 0; i < enemy2ArrayList.size(); i++)
            if (!enemy2ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar2, enemy2ArrayList.get(i).x, enemy2ArrayList.get(i).y, null);

      //CODE TO DISPLAY ENEMY CARS 3
        for (int i = 0; i < enemy3ArrayList.size(); i++)
            if (!enemy3ArrayList.get(i).hidden)
                graphics.drawImage(Resources.enemyCar3, enemy3ArrayList.get(i).x, enemy3ArrayList.get(i).y, null);

       //DRAW DEATH
       for (int i = 0; i < DeathList.size(); i++) {
        DeathList.get(i).updatePos();
        if (DeathList.get(i).hidden == false)
            graphics.drawImage(Resources.death, DeathList.get(i).x, DeathList.get(i).y, null);
    }
        
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
