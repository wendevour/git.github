package bookflight.bookflight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName, lastName, passPhrase;
    Spinner spinnerCountry, spinnerClass;
    RadioButton rWindow, rAisle, rDontCare;
    SeekBar seekbarLuggage;
    CheckBox Vegetarian;
    Button PlaceReservationBtn;
    TextView luggage;

    String[] Countries = {"France", "South Korea", "Malaysia", "Japan", "China", "Canada", "America", "Germany", "Italy", "Singapore",
                          "United Kingdom", "Italy", "Singapore", "Switzerland", "Brazil", "Mexico", "New Zealand", "Spain", "Greece", "Thailand",
                          "Vietnam", "Belgium", "Australia", "Bangladesh", "Cambodia", "Colombia", "Denmark", "Finland", "Georgia", "Maldives"};

    String[] Class = {"Business", "Economy", "Premium Economy", "First Class"};

    int luggageprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        passPhrase = (EditText) findViewById(R.id.passPhrase);
        spinnerCountry = (Spinner) findViewById(R.id.spinnerCountry);
        spinnerClass = (Spinner) findViewById(R.id.spinnerClass);
        rWindow = (RadioButton) findViewById(R.id.rWindow);
        rAisle = (RadioButton) findViewById(R.id.rAisle);
        rDontCare = (RadioButton) findViewById(R.id.rDontCare);
        seekbarLuggage = (SeekBar) findViewById(R.id.seekbarLuggage);
        Vegetarian = (CheckBox) findViewById(R.id.Vegetarian);
        PlaceReservationBtn = (Button) findViewById(R.id.PlaceReservationBtn);

        ArrayAdapter<String> adapterCountries = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Countries);
        spinnerCountry.setAdapter(adapterCountries);

        ArrayAdapter<String> adapterClass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Class);
        spinnerClass.setAdapter(adapterClass);

        seekbarLuggage.setMax(100);
        seekbarLuggage.setProgress(luggageprogress);

        luggage = (TextView) findViewById(R.id.luggage);

        luggage.setText(luggageprogress + "kg");
        seekbarLuggage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                luggage.setText(1 + " kg");
                luggageprogress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this, "Seek bar progress is :" + luggageprogress,
                        Toast.LENGTH_SHORT).show();
            }
        });

        rWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = ((RadioButton)v).isChecked();
                if (checked){
                    Toast.makeText(getApplicationContext(), "Window", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rAisle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = ((RadioButton)v).isChecked();
                if (checked) {
                    Toast.makeText(getApplicationContext(), "Aisle", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rDontCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = ((RadioButton)v).isChecked();
                if (checked) {
                    Toast.makeText(getApplicationContext(), "Don't care", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Vegetarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (((CheckBox) view).isChecked()) {
                    Toast.makeText(getApplicationContext(), Vegetarian.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    }

