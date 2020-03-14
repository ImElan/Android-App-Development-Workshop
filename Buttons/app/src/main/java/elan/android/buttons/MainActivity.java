package elan.android.buttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button ClickMeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickMeButton = findViewById(R.id.click_me_button);
        ClickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"You Clicked Me From Custom On Click Method",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void click(View view) {
        Toast.makeText(MainActivity.this,"You Clicked me From On Click Method ..!",Toast.LENGTH_SHORT).show();
    }
}
