package elan.android.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup gender = findViewById(R.id.gender_group);

        Button submitButton = findViewById(R.id.sumbit_id);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int radioId = gender.getCheckedRadioButtonId();
                final RadioButton genderRadioButton = findViewById(radioId);
                String Gender = genderRadioButton.getText().toString();
                Toast.makeText(MainActivity.this,Gender,Toast.LENGTH_SHORT).show();


                gender.clearCheck();
            }
        });
    }
}
