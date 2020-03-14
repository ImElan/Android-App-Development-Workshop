package app.android.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private HomeFragment mHome;
    private ChatsFragment mChats;
    private StatusFragment mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHome = new HomeFragment();
        mChats = new ChatsFragment();
        mStatus = new StatusFragment();

        Button homeButton = findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment(mHome);
            }
        });

        Button chatButton = findViewById(R.id.chat_id);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment(mChats);
            }
        });

        Button statusButton = findViewById(R.id.status_id);
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment(mStatus);
            }
        });

    }



    public void SetFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,fragment);
        fragmentTransaction.commit();
    }
}
