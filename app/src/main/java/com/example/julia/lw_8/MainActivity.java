package com.example.julia.lw_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TextView mama;
    TextView papa;
    double x, y, X=0, Y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        papa = (TextView) findViewById(R.id.down);
        papa.setOnTouchListener(this);
        mama = (TextView) findViewById(R.id.move);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();   // текущая координата X пальца
        y = event.getY();   // текущая координата Y пальца

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                // здесь делаем что-то, чтобы обработать событие нажатия
                papa.setText("x= "+x+" y= "+y);
                X=x;
                Y=y;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                // здесь обработываем событие перемещения пальца
                if ((X>x || X<x)||(Y>y || Y<y)){
                    X=x;
                    Y=y;
                    mama.setText("x= "+X+" y= "+Y);
                }
                break;
            case MotionEvent.ACTION_UP: // отпускание
                // здесь делаем что-то, чтобы обработать событие отпускания
                break;
            case MotionEvent.ACTION_CANCEL:
                // событие отмены
                break;
        }
        // здесь можем вывести нужные надписи на papa
        return true;
    }
}