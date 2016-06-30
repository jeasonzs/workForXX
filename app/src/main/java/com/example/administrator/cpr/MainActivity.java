package com.example.administrator.cpr;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    DummyService.DummyBinder dummyBinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonMainTech).setOnTouchListener(this);
        findViewById(R.id.buttonMainExam).setOnTouchListener(this);
        findViewById(R.id.buttonMainSetting).setOnTouchListener(this);
        findViewById(R.id.buttonMainAbout).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){
//            v.getBackground().setColorFilter(utils.highLightColorFilter());
        }
        else if(event.getAction()==MotionEvent.ACTION_UP){
//            v.getBackground().setColorFilter(utils.normalColorFilter());
            switch (v.getId()) {
                case R.id.buttonMainTech:
                    startActivity(new Intent(MainActivity.this,TechActivity.class));
                    break;
                case R.id.buttonMainExam:
                    startActivity(new Intent(MainActivity.this,TechActivity.class));
                    break;
                case R.id.buttonMainSetting:
//                    startActivity(new Intent(MainActivity.this,TechActivity.class));
                    Log.v("CPR", "setting");
//                    startService(new Intent(MainActivity.this,DummyService.class));

                    ServiceConnection connection = new ServiceConnection() {
                        @Override
                        public void onServiceConnected(ComponentName name, IBinder service) {
                            dummyBinder = (DummyService.DummyBinder)service;
                        }

                        @Override
                        public void onServiceDisconnected(ComponentName name) {
                            dummyBinder = null;
                        }
                    };
                    bindService(new Intent(MainActivity.this, DummyService.class), connection, Context.BIND_AUTO_CREATE);
                    break;
                case R.id.buttonMainAbout:
//                    startActivity(new Intent(MainActivity.this,TechActivity.class));
                    dummyBinder.getService().startCpr();
                    break;
            }
        }
        return true;
    }
}
