package org.scorelab.soundcom;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    // Splash screen timer
    private static int TIME_OUT = 4000;
    private ImageView logo;
    private ImageView text;
    private ImageView topbar;
    private ImageView logo2;
    private RelativeLayout parent;
    private TextView subtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        logo = (ImageView) findViewById(R.id.imageView4);
        text = (ImageView) findViewById(R.id.imageView5);
        topbar = (ImageView) findViewById(R.id.topbar);
        parent=(RelativeLayout) findViewById(R.id.parent);
        subtext=(TextView) findViewById(R.id.subtext);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        logo.startAnimation(myanim);
        text.startAnimation(myanim);
        topbar.startAnimation(myanim);
        subtext.startAnimation(myanim);
        Animation anim=AnimationUtils.loadAnimation(this, R.anim.translate);
        logo.startAnimation(anim);
        text.startAnimation(anim);
        ColorDrawable[] color = {new ColorDrawable(Color.DKGRAY), new ColorDrawable(Color.BLACK)};
        TransitionDrawable trans = new TransitionDrawable(color);
        parent.setBackground(trans);
        trans.startTransition(2000);
        new Handler().postDelayed(new Runnable() {

            /*
			 * Showing splash screen with a timer.
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start app main activity
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);

                // Close activity
                finish();
            }
        }, TIME_OUT);
    }
}
