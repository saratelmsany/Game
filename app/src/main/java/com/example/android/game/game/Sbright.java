package com.example.android.game.game;

import android.app.Activity;
import android.util.Log;


/**
 * Created by Sara on 8/10/2016.
 */
public class Sbright   {

    private int noOfLifes=3;
    protected Activity context;


   public Sbright(Activity activity){
     //  super(activity);
       this.context=activity;
}

    public void update() {

    }

    public int isLife() {
        int life;
        if (noOfLifes > 0)
        { life=1;}
        else
        {life=0;}
        return life;
    }
    public void AddLife(){
        noOfLifes++;
    }
    public void decrementLife(){
        if(noOfLifes>0) noOfLifes--;
        Log.i(this.toString(),"lifes="+noOfLifes);
    }
}
