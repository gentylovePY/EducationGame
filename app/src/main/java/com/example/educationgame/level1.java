package com.example.educationgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class level1 extends AppCompatActivity {
private Button onClickBack;
    Dialog dialog;
    private Button  onClickContinuelevel1;
    private TextView onClickXEnd;
    Dialog dialogend;
    private Button onClickContinue;
    private TextView onClickX;
    public int numleft;
    public  int numright;
    Array array = new Array();//создание обьектов из класса Array
    Random randrom = new Random();
    public int count = 0;
    public int i1 =0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        TextView text_levels = findViewById(R.id.textViewLevels);
        text_levels.setText(R.string.level1);


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //скругление углов
        final ImageView img_left =(ImageView) findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        final ImageView img_right =(ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //заверш скругление

        //путь к  текствью
        final TextView text_left = findViewById(R.id.text_left);
        final TextView text_right = findViewById(R.id.text_right);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//cкрытие диалог окна
        dialog.setContentView(R.layout.previewdialog);//путь к макету
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачнонсть
        dialog.setCancelable(false);//системной кнопкой нельзя закрыть

        //закрытие
        dialog.show();//показ диалог окно


        //--------------------------------------
        dialogend = new Dialog(this);
        dialogend.requestWindowFeature(Window.FEATURE_NO_TITLE);//cкрытие диалог окна
        dialogend.setContentView(R.layout.previewdialog_end);//путь к макету
        dialogend.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачнонсть
        dialogend.setCancelable(false);//системной кнопкой нельзя закрыть

        //закрытие


        //--------------------------------------



        //массив для прогресса
        final int[] progress = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,
                R.id.point11,
                R.id.point12,
                R.id.point13,
                R.id.point14,
                R.id.point15,
                R.id.point16,
                R.id.point17,
                R.id.point18,
                R.id.point19,
                R.id.point20,
        };


        //Анимация
        final Animation a = AnimationUtils.loadAnimation(level1.this,R.anim.beta);

        numleft = randrom.nextInt(10);//генерация
        img_left.setImageResource(array.images1[numleft]);
        text_left.setText(array.texts1[numleft]);//достаем из масива текст

        numright = randrom.nextInt(10);//генерация


        //цикл проверяющие одинак цифры
        while (numleft==numright){
            numright=randrom.nextInt(10);
        }
        img_right.setImageResource(array.images1[numright]);
        text_right.setText(array.texts1[numright]);//достаем из масива текст

        //обработка нажатие на картинку
      img_left.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View v, MotionEvent event) {
              if (event.getAction()==MotionEvent.ACTION_DOWN){
                  img_right.setEnabled(false);
                  if (numleft>numright){
                      img_left.setImageResource(R.drawable.img_true);
                  }else {
                      img_left.setImageResource(R.drawable.img_false1);
                  }

              }else if (event.getAction()==MotionEvent.ACTION_UP){
                  if (numleft>numright){
                      if (count<20){count=count+1;}
                      for (int i=0;i<20;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points); }
                      for (int i=0;i<count;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points_green); }

                  }



                  else {
                      if (count>0){
                          if (count==1){
                              count=0;
                          }else {count=count-2;}
                      }
                      for (int i=0;i<19;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points); }
                      for (int i=0;i<count;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points_green); }
                  }




                  if (count==20){
                      dialogend.show();


                  }else {numleft = randrom.nextInt(10);//генерация
                      img_left.setImageResource(array.images1[numleft]);
                      img_left.startAnimation(a);
                      text_left.setText(array.texts1[numleft]);//достаем из масива текст

                      numright = randrom.nextInt(10);//генерация


                      //цикл проверяющие одинак цифры
                      while (numleft==numright){
                          numright=randrom.nextInt(10);
                      }
                      img_right.setImageResource(array.images1[numright]);
                      img_right.startAnimation(a);
                      text_right.setText(array.texts1[numright]);}
                  img_right.setEnabled(true);
              }

              return true;
          }
      });



        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    img_left.setEnabled(false);
                    if (numleft<numright){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false1);
                    }

                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    if (numleft<numright){
                        if (count<20){count=count+1;}
                        for (int i=0;i<20;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points); }
                        for (int i=0;i<count;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points_green); }

                    }



                    else {
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {count=count-2;}
                        }
                        for (int i=0;i<19;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points); }
                        for (int i=0;i<count;i++){TextView tv=findViewById(progress[i]);tv.setBackgroundResource(R.drawable.style_points_green); }
                    }




                    if (count==20){
                        dialogend.show();
                    }else {numleft = randrom.nextInt(10);//генерация
                        img_left.setImageResource(array.images1[numleft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts1[numleft]);//достаем из масива текст

                        numright = randrom.nextInt(10);//генерация


                        //цикл проверяющие одинак цифры
                        while (numleft==numright){
                            numright=randrom.nextInt(10);
                        }
                        img_right.setImageResource(array.images1[numright]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts1[numright]);}
                    img_left.setEnabled(true);
                }

                return true;
            }
        });




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            Intent intent = new Intent(level1.this,MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

    public void onClickBack(View view) {
        onClickBack = findViewById(R.id.buttonBack);
        try {
            Intent intent = new Intent(level1.this,MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    public void onClickContinue (View view){
        onClickContinue=dialog.findViewById(R.id.buttoncontinue);
        try {dialog.dismiss();

        }catch (Exception e){

        }
    }


    public void onClickX(View view){
        onClickX = dialog.findViewById(R.id.btnclose);
        try { dialog.dismiss();//закрытие диалогового окна

        }catch (Exception e){

        }

    }
    public void onClickXEnd(View view){
        onClickXEnd = dialogend.findViewById(R.id.btncloseEnd);
        try {Intent intent = new Intent(level1.this,MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    public void onClickContinuelevel1(View view){
        onClickContinuelevel1=dialogend.findViewById(R.id.buttoncontinuelevel1);
        try { Intent intent = new Intent(level1.this,level2.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

}
