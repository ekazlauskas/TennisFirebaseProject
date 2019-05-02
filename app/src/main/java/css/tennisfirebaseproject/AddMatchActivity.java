package css.tennisfirebaseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        etOpponent = (EditText) findViewById(R.id.editTextOpponent);
        etPlayer = (EditText) findViewById(R.id.editTextPlayer);
        etScore = (EditText) findViewById(R.id.editTextScore);
        etDate = (EditText) findViewById(R.id.editTextDate);
        matchSpinner = (Spinner) findViewById(R.id.spinnerPlacement);

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

                if (opponent.isEmpty()) {
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Opponent Name", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (player.isEmpty()) {
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Player Name", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (score.isEmpty()) {
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Match Score", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if (date.isEmpty()) {
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Date", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    //Sends message to user stating that the Match Info is being saved and added
                    //to ListView
                    Toast toast = Toast.makeText(v.getContext(), "Saving Match", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}

