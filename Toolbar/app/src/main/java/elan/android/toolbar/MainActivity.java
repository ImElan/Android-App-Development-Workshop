package elan.android.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.about_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.item_1:
                Toast.makeText(MainActivity.this,"You Selected Item 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_2:
                Toast.makeText(MainActivity.this,"You Selected Item 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_3:
                Toast.makeText(MainActivity.this,"You Selected Item 3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(MainActivity.this,"Search...",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
