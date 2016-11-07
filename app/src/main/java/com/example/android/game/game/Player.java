package com.example.android.game.game;

import android.app.Activity;
import android.util.Log;

/**
 * Created by Sara on 8/14/2016.
 */
public class Player extends Sbright implements MovingObjectDelegate{


    private static int score;
    private Level l;
    private MovingObject m;


    public Player(Activity activity) {
        super(activity);
    }

    public void addScore(int increment)
    {
       // increment=l.point;
       score+=increment;
        Log.i(this.toString(),"score"+score);
    }
    public int viewScore()
    {return score;}

    @Override
    public void Clicked(int score) {
        addScore(score);
    }
    @Override
    public void addLife(){
        AddLife();
    }
}
