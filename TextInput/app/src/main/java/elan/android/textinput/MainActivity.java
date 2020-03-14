package elan.android.textinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{
    private EditText name;
    private TextInputLayout nameInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_text);
        nameInputLayout = findViewById(R.id.name_inputLayout);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                Toast.makeText(MainActivity.this,"Your Name is "+nameText,Toast.LENGTH_SHORT).show();
            }
        });

        Button submitButtonTwo = findViewById(R.id.submit_2_button);
        submitButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = nameInputLayout.getEditText().getText().toString();
                Toast.makeText(MainActivity.this,"Your Name is "+text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
