package com.example.android.game.game;

import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sara on 8/24/2016.
 */
public class Level {
    private Activity activity;
    private List<MovingObject> mos;
    private List<MovingObject> mog;
    private List<MovingObject> mor;
    private List<MovingObject> moh;
    private int speed;
    private int count=0;
    private int countG=0;
    DisplayMetrics displayMetrics;
    private int x=20;
    public static int point=2;
    Sbright s;
    MovingObject m;
    Game g;
    Player p;


    public Level(Activity activity, int speed) {
        this.activity = activity;

        mos=new ArrayList<>();
        mog=new ArrayList<>();
        mor=new ArrayList<>();
        moh=new ArrayList<>();
        p=new Player(activity);
        this.speed = speed;
        displayMetrics = new DisplayMetrics();
        s=new Sbright(activity);
      //  g=new Game(activity);
       m=new MovingObject(activity,x,400,5,speed);
        m.setDelegate(p);
    }


    public void updateLevel() {
        activity.runOnUiThread(new Runnable() {

            public void run() {
                count++;
                for(int i=0;i<mos.size();i++){
                    mos.get(i).update();
                    if(mos.get(i).gety()<0)
                        s.decrementLife();
                }
                for(int i=0;i<mog.size();i++){
                    mog.get(i).updateg();}

                for(int i=0;i<mor.size();i++){
                    mor.get(i).updater();}
                for(int i=0;i<moh.size();i++){
                    moh.get(i).updateh();}


                while (count == 30) {
                    setPosition();

                    WindowManager wm = (WindowManager) activity.getSystemService(activity.WINDOW_SERVICE);
                    Display display = wm.getDefaultDisplay();
                    Point size = new Point();
                    display.getSize(size);
                    int height = size.y;
                    // Log.i(this.toString(), "hight " + height);
                     if(check()==ENUM.win) {

                         mos.add(new MovingObject(activity, x, height, 1, speed));
                         mog.add(new MovingObject(activity, x + 100, height, 5, speed + 20));
                         mor.add(new MovingObject(activity, x + 150, height, -5, speed - 10));
                         moh.add(new MovingObject(activity, x, height, 10, speed + 15));

                         count = 0;
                     } else {
                        for(int i=0;i<mos.size();i++){
                            mos.get(i).delete();
                        }
                        mos.clear();
                    }
                }
            }
        });



    }// Math.round(displayMetrics.heightPixels / displayMetrics.density);

    public void setPosition(){
        WindowManager wm = (WindowManager) activity.getSystemService(activity.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
       // Log.i(this.toString(), "Width= " + width);

        if(x<=width-180)
            x+=200;
        else if(x>=32)
            x-=(width-50);
        else
            x=0;
    }
    public ENUM check(){
        if(p.isLife()==1)
            return ENUM.win;
        else if(p.isLife()==0)
            return ENUM.lose;
        return check();
    }



}


