package app.android.firebasebasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final EditText ValueText = findViewById(R.id.value_id);
        final EditText KeyText = findViewById(R.id.key_id);
        Button SubmitButton = findViewById(R.id.submit_button);

        // CREATE
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = ValueText.getText().toString();
                String key = KeyText.getText().toString();
                mDatabase.child("Users").child(key).setValue(value).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this,"Values Added To Database",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // CREATING MULTIPLE OBJECTS

        final EditText NameText = findViewById(R.id.name_id);
        final EditText EmailText = findViewById(R.id.email_id);
        final EditText CityText = findViewById(R.id.city_id);
        final EditText Key_2_Text = findViewById(R.id.key_2_id);
        Button Submit_2_Button = findViewById(R.id.submit_2_button);

        Submit_2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = NameText.getText().toString();
                String email = EmailText.getText().toString();
                String city = CityText.getText().toString();
                String key = Key_2_Text.getText().toString();

                   Map<String,String> map = new HashMap<>();
                   map.put("name",name);
                   map.put("email",email);
                   map.put("city",city);

                   mDatabase.child("Details").child(key).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                       @Override
                       public void onComplete(@NonNull Task<Void> task) {
                           Toast.makeText(MainActivity.this,"Values Added To Database",Toast.LENGTH_SHORT).show();
                       }
                   });
            }
        });

        // UPDATE - IF YOU USE THE SAME KEY AND SET THE VALUES IT IS UPDATE

        // READ

        final Button ViewDetails = findViewById(R.id.view_details);
        ViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DetailsIntent = new Intent(MainActivity.this,ViewDetails.class);
                startActivity(DetailsIntent);
            }
        });


        // DELETE

        Button DeleteButton = findViewById(R.id.delete_button);
        final EditText DeleteKey = findViewById(R.id.delete_key_id);

        DeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String keyToDelete = DeleteKey.getText().toString();
                mDatabase.child("Details").child(keyToDelete).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity.this,"Values Deleted From Database",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
