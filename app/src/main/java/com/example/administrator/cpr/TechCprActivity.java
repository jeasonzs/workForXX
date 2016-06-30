package com.example.administrator.cpr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class TechCprActivity extends AppCompatActivity implements View.OnTouchListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_cpr);
        findViewById(R.id.buttonTechCprPress).setOnTouchListener(this);
        findViewById(R.id.buttonTechCprVent).setOnTouchListener(this);
        findViewById(R.id.buttonTechCprSingle).setOnTouchListener(this);
        findViewById(R.id.buttonTechCprDouble).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){
//            v.getBackground().setColorFilter(utils.highLightColorFilter());
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
//            v.getBackground().setColorFilter(utils.normalColorFilter());
//            switch (v.getId()) {
//                case R.id.buttonMainTech:
//                    startActivity(new Intent(TechCprActivity.this,TechActivity.class));
//                    break;
//                case R.id.buttonMainExam:
//                    startActivity(new Intent(TechCprActivity.this,TechActivity.class));
//                    break;
//                case R.id.buttonMainSetting:
//                    startActivity(new Intent(TechCprActivity.this,TechActivity.class));
//                    break;
//                case R.id.buttonMainAbout:
//                    startActivity(new Intent(TechCprActivity.this,TechActivity.class));
//                    break;
//            }
        }
        return true;
    }
}
