import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

public class StageOne extends State {

    private int time = 100;
    private Car car = new Car();
    private enemy1 enemy11 = new enemy1(-300, 14);
    private enemy1 enemy12 = new enemy1(-615, 14);
    private enemy1 enemy13 = new enemy1(-930, 14);
    private Death death = new Death(-600, 10);
    private FinalLine finalLine = new FinalLine(10, -6000);
    private Road road = new Road(10);
    private boolean finishStage = false;

    public List<enemy1> enemy1List = new ArrayList<>();


    private int count = 0;

    @Override
    public void update(Graphics graphics) {

        if (count == 0) {
            enemy1List.add(enemy11);
            enemy1List.add(enemy12);
            enemy1List.add(enemy13);
            Resources.welcomeTone.stop();
            Resources.carMoving.loop();
        }
        count++;

        //CODE TO REDUCE TIME
        if (count % 10 == 0 && !finishStage)
            time--;

        //CODE TO DRAW ROAD
        graphics.drawImage(Resources.roadImage, road.x, road.y, null);

        //CODE TO DRAW FINISH LINE
        graphics.drawImage(Resources.finishLineImage, finalLine.x, finalLine.y, null);

        //CODE TO DRAW CAR
        graphics.drawImage(Resources.playerCar, car.x, car.y, null);

        //CODE TO DRAW death
        if (!death.hidden)
            graphics.drawImage(Resources.death, death.x, death.y, null);

        //CODE TO DRAW RED CARS
        for (int i = 0; i < enemy1List.size(); i++) {
            enemy1List.get(i).updatePos();
            if (enemy1List.get(i).hidden == false)
                graphics.drawImage(Resources.enemyCar1, enemy1List.get(i).x, enemy1List.get(i).y, null);
        }

        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        graphics.drawString("STAGE - 1", 260, 30);

        //CODE TO SHOW TIME AND PLAY PAUSE BUTTON
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
           graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
        }

        //CODE TO CHECK WHEATHER CAR REACHED FINISH LINE OR NOT
        if (finalLine.checkIntersection(car)) {
            finishStage = true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel = 0;
            for (int i = 0; i < enemy1List.size(); i++) {
                enemy1List.get(i).hidden = true;
                enemy1List.get(i).yvel = 0;

            }
            death.hidden = true;
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;
            death.yvel = 0;

        }

        //CODE TO CHECK INTERSECTION OF CAR WITH death OR TIMES UP
        if (finishStage == false && death.checkIntersection(car) || time < 0) {
            Resources.carCrash.play();
            for (int i = 0; i < 1000; i++) {
                graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
            }
            GamePanel.currentState = new GameOverState();
        }

        //CODE TO MOVE TO SECOND STAGE
        if (car.y < -1000)
            GamePanel.currentState = new WelcomeToStage2();

        //CODE TO HIDE RED CARS WHEN THEY HIT death
        for (int i = 0; i < enemy1List.size(); i++) {
            if (enemy1List.get(i).checkIntersection(death))
            	//diubah jadi false
                enemy1List.get(i).hidden = false;
        }

        //CODE TO UPDATE POSITIONS OF EVERY ELEMENT
        road.updatePos();
        finalLine.updatePos();
        car.updatePos();
        death.updatePos();

        //CODE TO CHECK INTERSECTION OF CAR WITH ENEMY CAR
        for (int i = 0; i < enemy1List.size(); i++) {
            if ((enemy1List.get(i).hidden == false && car.checkIntersection(enemy1List.get(i)) && !finishStage)) {
                enemy1List.get(i).hidden = true;
                Resources.carCrash.play();

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);

                time -= 5;
            }

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
