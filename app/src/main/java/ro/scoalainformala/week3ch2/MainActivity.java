package ro.scoalainformala.week3ch2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.frame_layout);
        setContentView(R.layout.spinner_layout);


        Spinner spinner = findViewById(R.id.spinner);

        List<String> dataSource = getSource();

        ArrayAdapter<String> arrayAdapter = getAdapter(dataSource);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                CharSequence text = "Selected: "+spinner.getSelectedItem();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Context context = getApplicationContext();
                CharSequence text = "Nothing selected.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("MainActivity","onItemSelected: "+dataSource.get(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                Log.d("MainActivity","onNothingSelected");
//            }
//        });
    }
    private List<String> getSource() {
        List<String> desertVersions = new ArrayList<>();

        desertVersions.add("Cupcake");
        desertVersions.add("Donut");
        desertVersions.add("Eclair");
        desertVersions.add("KitKat");
        desertVersions.add("Pie");

        return desertVersions;
    }

    private ArrayAdapter<String> getAdapter(List<String> dataSource) {

        return new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataSource);
    }
}