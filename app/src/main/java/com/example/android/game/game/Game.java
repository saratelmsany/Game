package com.example.android.game.game;

import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sara on 8/10/2016.
 */
public class Game {

    public static Timer myTimer;
    private Activity context;

    Player p;
    MovingObject mo;
    Level l;

    public static int speed;

    public Game(Activity activity) {
        this.context = activity;
        p = new Player(activity);
        //ha3mel method create el values ll constructor
        //mo=new MovingObject(activity,50,100,2);
        //mo.setDelegate(p);
        l = new Level(activity, 7);

    }

    public void start() {
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                TimerMethod();
            }
        }, 0, 1000 / 33);
    }

    public void TimerMethod() {
        // mo.update();
        l.updateLevel();
    }

    public void pause() {
        myTimer.cancel();

    }

  /*  public void win() {
        if (l.check() == ENUM.win)
            TimerMethod();
        else {
            pause();
            Toast.makeText(context, "LOSER", Toast.LENGTH_LONG).show();
        }
    }*/
}
