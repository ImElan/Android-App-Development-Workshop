package elan.android.toastandlogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LOG_TAG","I'm inside On Create Method");

        Toast.makeText(MainActivity.this,"App Started",Toast.LENGTH_LONG).show();
    }
}
