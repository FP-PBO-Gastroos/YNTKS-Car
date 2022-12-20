import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class StageTwo extends State {
    private int time=120;
    private Road road = new Road(11);
    private Car car = new Car();
    private FinalLine finalLine = new FinalLine(12,-8000);
    private enemy1 enemy11 = new enemy1(-650,15);
    private enemy1 enemy12= new enemy1(-1150,15);
    private enemy2 enemy21 = new enemy2(-400,15);
    private enemy2 enemy22 = new enemy2(-900,15);
    private enemy2 enemy23 = new enemy2(-1400,15);
    private Death death1 = new Death(-600, 10);
    private Death death2 = new Death(-300, 20);
    private ExtraTime time1 = new ExtraTime(-100, 20);
    private ExtraTime time2 = new ExtraTime(-400, 30);
    private int count=0;

    private List<Elements> list = new ArrayList<>();
    private List<enemy1> enemy1ArrayList = new ArrayList<>();
    private List<enemy2> enemy2ArrayList = new ArrayList<>();
    public List<Death> DeathList = new ArrayList<>();
    public List<ExtraTime> TimeList = new ArrayList<>();
    
    private boolean finishStage=false;




    @Override
    public void update(Graphics graphics) {


        if (count==0)
        {

            Resources.welcomeTone.stop();
            Resources.mainMenuTone.stop();
            Resources.carMoving.loop();

        }
        enemy1ArrayList.clear();
        enemy2ArrayList.clear();;
        DeathList.clear();
        TimeList.clear();
        list.clear();
        enemy1ArrayList.add(enemy11);
        enemy1ArrayList.add(enemy12);
        enemy2ArrayList.add(enemy21);
        enemy2ArrayList.add(enemy22);
        enemy2ArrayList.add(enemy23);
        DeathList.add(death1);
        DeathList.add(death2);
        TimeList.add(time1);
        TimeList.add(time2);
        list.addAll(enemy1ArrayList);
        list.addAll(enemy2ArrayList);
        list.addAll(DeathList);
        list.addAll(TimeList);

        // list.add(death);
        count++;

        //CODE TO REDUCE TIME
        if (count%10==0&&!finishStage)
            time--;

        
        //CODE TO CHECK WHEATHER CAR REACHES FINISH LINE OR NOT
        if (finalLine.checkIntersection(car))
        {
            finishStage=true;
            Resources.carMoving.stop();
            Resources.finishTone.play();
            finalLine.yvel=0;
            for (int i = 0 ; i <list.size();i++)
            {

                list.get(i).hidden = true;
                list.get(i).yvel = 0;

            }
            for (int i = 0; i < DeathList.size(); i++) {
            	DeathList.get(i).yvel = 0;
                DeathList.get(i).hidden = true;
            }
            for (int i = 0; i < TimeList.size(); i++) {
            	TimeList.get(i).yvel = 0;
                TimeList.get(i).hidden = true;
            }
            car.xVel = 0;
            car.yvel = -25;
            road.yvel = 0;
            

        }

        // CODE TO MOVE TO NEXT STAGE
        if (car.y<-1000)
            GamePanel.currentState= new WelcomeToStage3();

        //CODE TO CHECK INTERSECTION OF CAR WITH DEATH
        for (int i = 0; i < DeathList.size(); i++) {
            if ((DeathList.get(i).hidden == false && car.checkIntersection(DeathList.get(i)) && !finishStage )) {
                DeathList.get(i).hidden = true;
                Resources.carCrash.play();
                if (GamePanel.muteUnmute) {
                	Resources.carCrash.stop();
                }

                for (int j = 0; j < 5000; j++)
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
              
                GamePanel.currentState = new GameOverState();
            }
            else if (time < 0) {
            	GamePanel.currentState = new GameOverState();
            }

        }
        
        //CODE TO CHECK INTERSECTION OF CAR WITH EXTRATIME
        for (int i = 0; i < TimeList.size(); i++) {
            if ((TimeList.get(i).hidden == false && car.checkIntersection(TimeList.get(i)) && !finishStage)) {
                TimeList.get(i).hidden = true;

                time += 7;
            }

        }

        //CODE TO DRAW THESE ELEMENTS
        graphics.drawImage(Resources.roadImage,road.x,road.y,null);
        graphics.drawImage(Resources.finishLineImage,finalLine.x,finalLine.y,null);
        graphics.drawImage(Resources.playerCar,car.x,car.y,null);
        graphics.setFont(new Font(Font.MONOSPACED,Font.BOLD,15));
        graphics.drawString("STAGE - 2",260,30);

        //CODE TO DISPLAY TIME AND PLAY PAUSE BUTTON
        if (!finishStage) {
            graphics.drawString("TIME :" + time + "s", 260, 50);
            graphics.drawImage(Resources.playPause,355, 20, 40, 35,null);
            graphics.drawImage(Resources.muteUnmute,355, 60, 40, 35,null);
        }

        //CODE TO DISPLAY ENEMY CARS 1
        for (int i = 0 ; i<enemy1ArrayList.size();i++)
            if (!enemy1ArrayList.get(i).hidden)
            graphics.drawImage(Resources.enemyCar1, enemy1ArrayList.get(i).x, enemy1ArrayList.get(i).y,null);

        //CODE TO DISPLAY ENEMY CARS 2
        for (int i = 0 ;i<enemy2ArrayList.size();i++)
            if (!enemy2ArrayList.get(i).hidden)
            graphics.drawImage(Resources.enemyCar2, enemy2ArrayList.get(i).x, enemy2ArrayList.get(i).y,null);

        //DRAW DEATH
        for (int i = 0; i < DeathList.size(); i++) {
            DeathList.get(i).updatePos();
            if (DeathList.get(i).hidden == false)
                graphics.drawImage(Resources.death, DeathList.get(i).x, DeathList.get(i).y, null);
        }
        
        //DRAW EXTRATIME
        for (int i = 0; i < TimeList.size(); i++) {
            TimeList.get(i).updatePos();
            if (TimeList.get(i).hidden == false)
                graphics.drawImage(Resources.time, TimeList.get(i).x, TimeList.get(i).y, null);
        }

        //CODE TO CHECK INTERSECTION OF CAR WITH OTHER ELEMENTS
        for (int i=0;i<list.size();i++)
        {
            if (car.checkIntersection(list.get(i))&&!list.get(i).hidden)
            {
                time-=7;
                
                if (!finishStage&&list.get(i) instanceof Death)
                    GamePanel.currentState=new GameOverState();
                else {
                    Resources.carCrash.play();
                    if (GamePanel.muteUnmute) {
                    	Resources.carCrash.stop();
                    }
                    list.get(i).hidden = true;
                }
                
                for (int j=0;j < 1000;j++)
                {
                    graphics.drawImage(Resources.crashBoomImage, car.x, car.y, null);
                }
            }
            
        }



        //CODE TO UPDATE POSITIONS OF EVERY ELEMENTS
        road.updatePos();
        car.updatePos();
        finalLine.updatePos();
       for (int i = 0 ; i <list.size();i++)
       {
           list.get(i).updatePos();
       }

    }

    @Override
    public void onMousepressed(MouseEvent e) {
        Elements.pause(e);
        Elements.muteUnmute(e);

    }

    @Override
    public void onKeyPresses(KeyEvent e) {
        Elements.carHandling(e,car);

}
}
