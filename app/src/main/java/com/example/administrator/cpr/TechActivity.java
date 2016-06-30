package com.example.administrator.cpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class TechActivity extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech);
        findViewById(R.id.buttonTechCpr).setOnTouchListener(this);
        findViewById(R.id.buttonTechAed).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
            switch (v.getId()) {
                case R.id.buttonTechCpr:
                    startActivity(new Intent(TechActivity.this,TechCprActivity.class));
                    break;
                case R.id.buttonTechAed:
                    startActivity(new Intent(TechActivity.this,TechCprActivity.class));
                    break;
            }
        }
        return true;
    }
}
