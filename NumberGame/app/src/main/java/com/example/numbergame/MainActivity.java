package com.example.numbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
     private TextView point;
    private int num1;
    private int num2;
    private int points=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initial();
    }
    public void UpdatePoints()
    {
        String pointText = getResources().getString(R.string.Score,points);
        point = findViewById(R.id.points_view);
        point.setText(pointText);
    }
    public void Initial()
    {
        UpdatePoints();
        Random r = new Random();
        while(true)
        {
            num1 = r.nextInt(20);
            num2 = r.nextInt(20);
            if(num1 != num2)
                break;
        }
        Button left = findViewById(R.id.Left_button_click);
        Button right = findViewById(R.id.Right_button_click);
        left.setText(String.valueOf(num1));
        right.setText(String.valueOf(num2));
    }
    public void Left_Button(View view)
    {
        if(num1>num2)
        {
            points++;
        }
        else
        {
            points--;
        }
        Initial();
    }

    public void right_Button(View view)
    {
        if(num2>num1)
        {
            points++;
        }
        else
        {
            points--;
        }
        Initial();
    }
}
