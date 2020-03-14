package elan.android.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_id);

        String content = textView.getText().toString();

        Toast.makeText(MainActivity.this,content,Toast.LENGTH_SHORT).show();


        Button changeText = findViewById(R.id.change_text_id);
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("You've Changed the Text");
            }
        });
    }
}
