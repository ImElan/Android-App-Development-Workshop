package app.android.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image_view);
//        imageView.setImageResource(R.drawable.monitor);

        Picasso.get()
                .load("https://images.unsplash.com/photo-1552053831-71594a27632d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=612&q=80")
                .placeholder(R.color.colorPrimary)
                .into(imageView);
    }
}
