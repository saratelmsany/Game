package com.example.android.game.game;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageButton;

import com.example.android.game.R;

/**
 * Created by Sara on 8/14/2016.
 */
public class MovingObject extends Sbright {
    public ImageButton button;
    private  int points;
    private MovingObjectDelegate delegate;
    private Game g;
    private int speed;
    private Player p;



    public void setDelegate(MovingObjectDelegate delegate) {
        this.delegate = delegate;
    }

    public MovingObject(Activity activity,int x,int y, final int points,int newSpeed) {
        super(activity);
        button=new ImageButton(activity);
        MainActivity.rl.addView(button);
        button.setX(x);
        button.setY(y);
        button.setBackgroundDrawable(null);
        speed=newSpeed;
        p=new Player(activity);
      //  button.setWidth(width);
      //  button.setHeight(height);
     //   button.setImageResource(R.drawable.ballon2);
      //  button.setImageResource(R.drawable.gift);

        this.points=points;
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate!=null){
                    delegate.Clicked(points);
                    delegate.addLife();
                }
                ((ViewGroup)button.getParent()).removeView(button);
            }
        });
    }
    @Override
    public void update() {
        super.update();

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setImageResource(R.drawable.ballon2);
                button.setY(button.getY() -speed);
                if(button.getY()<0)
                    p.decrementLife();
            }
        });
    }

    public void updateg() {
        super.update();

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setImageResource(R.drawable.gift2);
                button.setY(button.getY() -speed+10);

            }
        });
    }
    public void updater() {
        super.update();

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setImageResource(R.drawable.rock2);
                button.setY(button.getY() -speed);
            }
        });
    }
    public void updateh() {
        super.update();

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setImageResource(R.drawable.heart1);
                button.setY(button.getY() -speed+10);
            }
        });
    }

    public void delete(){
        ((ViewManager)(button.getParent())).removeView(button);
    }


    public float gety() {
       return  button.getY();

    }




    public void soundEffect(){

    }


}
