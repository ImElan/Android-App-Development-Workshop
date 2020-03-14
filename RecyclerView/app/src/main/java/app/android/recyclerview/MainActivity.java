package app.android.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<String> mImageUrls;
    private ArrayList<String> mNames;
    private RecyclerView mRecycler;
    private RecyclerViewAdapater mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = findViewById(R.id.main_recycler);
        mImageUrls = new ArrayList<>();
        mNames = new ArrayList<>();

        InitializeValues();

    }

    private void InitializeValues() {

        // FIRST ENTRY
        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSeroda-DF3FtivNi-lDryh5l2pxdDNt-2xt0fHesSPbNMVpDPS");
        mNames.add("London");

        // SECOND ENTRY
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/1d/Taj_Mahal_%28Edited%29.jpeg");
        mNames.add("India");

        // THIRD ENTRY
        mImageUrls.add("https://www.planetware.com/photos-large/USNY/usa-best-places-new-york.jpg");
        mNames.add("America");

        // FOURTH ENTRY
        mImageUrls.add("https://www.planetware.com/photos-large/CHN/china-towns-cities-beijing.jpg");
        mNames.add("China");

        // FIFTH ENTRY
        mImageUrls.add("https://www.telegraph.co.uk/content/dam/Travel/2017/April/hot-air-balloon-paris.jpg?imwidth=450");
        mNames.add("France");

        // SIXTH ENTRY
        mImageUrls.add("https://www.tripsavvy.com/thmb/lRBfZ-buAUjn6-TgQmIP_gEkYzQ=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-934870338-5b115c3beb97de0036471c4f.jpg");
        mNames.add("Canada");

        // SEVENTH ENTRY
        mImageUrls.add("https://rccl-h.assetsadobe.com/is/image/content/dam/royal/content/destinations/australia/australia-sydney-opera-house.jpg?$750x667$");
        mNames.add("Australia");

        CallRecycler();

    }

    private void CallRecycler() {
        mAdapter = new RecyclerViewAdapater(mImageUrls,mNames,this);
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setHasFixedSize(true);

    }
}
