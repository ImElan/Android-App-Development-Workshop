package app.android.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView ResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText NameEditText = findViewById(R.id.name_id);
        Button IntentButton = findViewById(R.id.intent_button);
        ResultText = findViewById(R.id.result_text_id);

        IntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = NameEditText.getText().toString();
                Intent NewActivity = new Intent(MainActivity.this,AnotherActivity.class);
                NewActivity.putExtra("nameKey",name);
                startActivityForResult(NewActivity,9000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 9000 && resultCode == RESULT_OK)
        {
            String result = data.getStringExtra("resultKey");
            ResultText.setText(result);
        }
    }
}
