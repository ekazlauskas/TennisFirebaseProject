package css.tennisfirebaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddMatchActivity extends AppCompatActivity {

    Button btnAddMatch;
    EditText etOpponent, etPlayer, etScore, etDate;
    Spinner matchSpinner;
    TennisFirebaseData tennisDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_match);

        //Lists all variables found within the Add Match xml file.
        etOpponent = findViewById(R.id.editTextOpponent);
        etPlayer = findViewById(R.id.editTextPlayer);
        etScore = findViewById(R.id.editTextScore);
        etDate = findViewById(R.id.editTextDate);
        matchSpinner = findViewById(R.id.spinnerPlacement);

        tennisDataSource = new TennisFirebaseData();
        //tennisDataSource.open();

        //sets up Button to save data to Main Activity
        btnAddMatch = findViewById(R.id.buttonSave);
        btnAddMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adds new Match Data to list
                String opponent = etOpponent.getText().toString();
                String placement = matchSpinner.getSelectedItem().toString();
                String player = etPlayer.getText().toString();
                String score = etScore.getText().toString();
                String date = etDate.getText().toString();
                //tennisDataSource.createMatch(opponent, placement, player, score, date);

            }
        });
    }


}
