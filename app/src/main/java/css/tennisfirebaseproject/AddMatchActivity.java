package css.tennisfirebaseproject;

import android.content.Intent;
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
        tennisDataSource.open();

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

                if (opponent.isEmpty()) {
                    //Sends error message to user if opponent field is empty
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Opponent Name", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                else if (player.isEmpty()) {
                    //Sends error message to user if player field is empty
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Player Name", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                else if (score.isEmpty()) {
                    //Sends error message to user if score field is empty
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Match Score", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                else if (date.isEmpty()) {
                    //Sends error message to user if date field is empty
                    Toast toast = Toast.makeText(v.getContext(), "ERROR: Please Enter Date", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                else{
                    //Sends message to user stating that the Match Info is being saved and added
                    //to ListView
                    Toast toast = Toast.makeText(v.getContext(), "Saving Match", Toast.LENGTH_SHORT);
                    toast.show();
                }

                //creates the tennis match and sends it to the firebase and the listview on the MainActivity
                tennisDataSource.createMatch(opponent, placement, player, score, date);

                //starts the intent to return the user to the MainActivity Screen
                Intent ResultIntent = new Intent(v.getContext(), MainActivity.class);
                finish();
                startActivity(ResultIntent);
            }
        });
    }
}

