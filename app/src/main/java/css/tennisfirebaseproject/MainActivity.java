package css.tennisfirebaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

        Button btnAdd, btnDelete, btnDetails;
        ListView ListViewMatches;
        ArrayAdapter<Tennis> tennisMatchAdapter;
        List<Tennis> tennisList;
        DatabaseReference myTennisDbRef;
        TennisFirebaseData tennisDataSource;
        TennisMatch tennisSelected;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFirebaseDataChange();
        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("Welcome to Tennis Tracker");

    }

    //This class is designed to help the app data update in real time, this will help
    //coaches and the head of athletic communications see the results of
    //matches so that they can update the CSS website.
    private void createFirebaseDataChange(){
        tennisDataSource = new TennisFirebaseData();
        myTennisDbRef = tennisDataSource.open();
        myTennisDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d("CISMOBILE", "Initalizing onDataChange()");
                tennisList = tennisDataSource.getallTennisMatch(dataSnapshot);
                tennisMatchAdapter = new TennisMatchAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, tennisList);
                ListViewMatches.setAdapter(tennisMatchAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("CANCEL", "Failed to read value.", error.toException());
            }
        });
    }

    //This class is designed to set up the Add Match button on the Mainactivity
    //so that the user of the application can go to the Add Match Screen to add match details
    //for the current match being played.
    private void createAddMatchButton(){
        //Sets up the button to add a match to the MainActivity using a separate activity
        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starts the Intent to go to the add match activity
                Intent detailAddIntent = new Intent(view.getcontext(), AddMatchActivity.class);
                finish();
                startActivity(detailAddIntent);
            }}};
;
            }
    }

