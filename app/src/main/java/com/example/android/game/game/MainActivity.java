package com.example.android.game.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.android.game.R;


public class MainActivity extends Activity {

    public static Button startbtn;
    private Button pausebtn;
  //  public static ImageButton object;
    Game game;
    MovingObject mo;
    public static RelativeLayout rl;
    Level l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // mo=new MovingObject();
        // object=(ImageButton)findViewById(R.id.moving);
        // mo.move();
        rl = (RelativeLayout) findViewById(R.id.relative);
        game = new Game(this);
        l=new Level(this,5);
        startbtn = (Button) findViewById(R.id.start);
        pausebtn = (Button) findViewById(R.id.pause);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.start();
                startbtn.setVisibility(View.INVISIBLE);
                pausebtn.setVisibility(View.VISIBLE);
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.pause();
                pausebtn.setVisibility(View.INVISIBLE);
                startbtn.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
