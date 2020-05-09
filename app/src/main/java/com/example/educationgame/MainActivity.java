package com.example.educationgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private TextView textView_activitymain1;
    private TextView textView_activitymain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onBackPressed() {
    if (backPressedTime+2000>System.currentTimeMillis()){
        backToast.cancel();
        super.onBackPressed();
        return;

      }else {
        backToast=Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти",Toast.LENGTH_SHORT);
        backToast.show();
    } backPressedTime=System.currentTimeMillis();

     }

    public void onClickButtonMain1(View view) {
        textView_activitymain1=findViewById(R.id.textView_activitymain1);
        try {
            Intent intent = new Intent(MainActivity.this,level1.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

    public void onClickButtonMain2(View view) {
        textView_activitymain2=findViewById(R.id.textView_activitymain2);
        try {
            Intent intent = new Intent(MainActivity.this,level2.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}
