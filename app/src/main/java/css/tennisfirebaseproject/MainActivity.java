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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnDelete, btnDetails;
    ListView ListViewMatches;
    ArrayAdapter<TennisMatch> tennisMatchAdapter;
    List<TennisMatch> tennisList;
    DatabaseReference myTennisDbRef;
    FirebaseDatabase tennisDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAddMatchButton();


        // Write a message to the database
        tennisDataSource = FirebaseDatabase.getInstance(); //Gets instance for Google Firebase
        myTennisDbRef = tennisDataSource.getReference("Tennis Matches");
        myTennisDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d("CISMOBILE", "Initalizing onDataChange()");
                for (DataSnapshot tennisSnapshot : ds.getChildren()) {
                    TennisMatch value = tennisSnapshot.getValue(TennisMatch.class);
                    tennisList.add(value);
                }

                //tennisMatchAdapter = new TennisMatchAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, tennisList);
                //ListViewMatches.setAdapter(tennisMatchAdapter);
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
    private void createAddMatchButton() {
        //Sets up the button to add a match to the MainActivity using a separate activity
        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starts Intent to go to the add match activity
                Intent detailActIntent = new Intent(v.getContext(), AddMatchActivity.class);
                finish();
                startActivity(detailActIntent);
            }
        });
    }
}






