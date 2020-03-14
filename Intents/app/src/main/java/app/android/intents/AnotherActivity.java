package app.android.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        String nameFromPreviousIntent = getIntent().getStringExtra("nameKey");
        TextView textView = findViewById(R.id.text_id);
        textView.setText(nameFromPreviousIntent);

        final EditText resultText = findViewById(R.id.result_id);
        Button sendButton = findViewById(R.id.send_back_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = resultText.getText().toString();
                Intent SendBack = new Intent(AnotherActivity.this,MainActivity.class);
                SendBack.putExtra("resultKey",result);
                setResult(RESULT_OK,SendBack);
                finish();
            }
        });
    }
}
