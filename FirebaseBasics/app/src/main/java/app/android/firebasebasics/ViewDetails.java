package app.android.firebasebasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewDetails extends AppCompatActivity {

    private TextView titleText;
    private TextView storyText;
    private TextView captionText;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        titleText = findViewById(R.id.title_id);
        storyText = findViewById(R.id.story_id);
        captionText = findViewById(R.id.caption_id);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String title = dataSnapshot.child("Users").child("title").getValue().toString();
                String story = dataSnapshot.child("Users").child("story").getValue().toString();
                String caption = dataSnapshot.child("Users").child("caption").getValue().toString();

                titleText.setText(title);
                storyText.setText(story);
                captionText.setText(caption);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
