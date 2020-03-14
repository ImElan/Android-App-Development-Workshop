package elan.android.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner States;
    private ArrayAdapter<CharSequence> states_adapter;
    private String state;

    private ArrayList<String> speciesList;
    private ArrayAdapter<String> speciesAdapter;

    private ArrayList<String> animalsList;
    private ArrayList<String> birdsList;
    private ArrayList<String> fishesList;
    private ArrayAdapter<String> speciesChildAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        States = findViewById(R.id.states_spinner);

        states_adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.states,android.R.layout.simple_spinner_item);
        states_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        States.setAdapter(states_adapter);

        States.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                state = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button SubmitButton = findViewById(R.id.submit_button);
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Your State is "+state,Toast.LENGTH_SHORT).show();
            }
        });

//
//        Spinner SpeciesParent = findViewById(R.id.species_parent_spinner);
//        final Spinner SpeciesChild = findViewById(R.id.species_child_spinner);
//
//        speciesList = new ArrayList<>();
//        speciesList.add("Animals");
//        speciesList.add("Birds");
//        speciesList.add("Fishes");
//
//        animalsList = new ArrayList<>();
//        animalsList.add("Lion");
//        animalsList.add("Tiger");
//        animalsList.add("Cheetah");
//
//        birdsList = new ArrayList<>();
//        birdsList.add("Eagle");
//        birdsList.add("Peacock");
//        birdsList.add("Dove");
//
//        fishesList = new ArrayList<>();
//        fishesList.add("Gold Fish");
//        fishesList.add("Shark");
//
//        speciesAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,speciesList);
//        SpeciesParent.setAdapter(speciesAdapter);
//
//        SpeciesParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(position == 0)
//                {
//                    speciesChildAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,animalsList);
//                }
//                if(position == 1)
//                {
//                    speciesChildAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,birdsList);
//                }
//                if(position == 2)
//                {
//                    speciesChildAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,fishesList);
//                }
//                SpeciesChild.setAdapter(speciesChildAdapter);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }
}
