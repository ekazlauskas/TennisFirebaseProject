package css.tennisfirebaseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnDelete;
    ListView ListViewMatch;
    ArrayAdapter<TennisMatch> tennisMatchAdapter;
    List<TennisMatch> tennisList;
    DatabaseReference myTennisDbRef;
    FirebaseDatabase tennisDataSource;
    int positionSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAddMatchButton();
        createDeleteButton();
        createListView();

        tennisList = new ArrayList<>();

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

                tennisMatchAdapter = new TennisMatchAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, tennisList);
                ListViewMatch.setAdapter(tennisMatchAdapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("CISMOBILE", "Failed to read value.", error.toException());
            }
        });
    }

    private void createListView(){
        ListViewMatch = (ListView) findViewById(R.id.ListViewMatches);
        ListViewMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> adapter, View parent, int position, long id) {
                positionSelected = position;
                Log.d("CISMOBILE", "Match selected at position " + positionSelected);
            }
        });
    }


    /**
     *  This class is designed to set up the Add Match button on the Mainactivity
     *  so that the user of the application can go to the Add Match Screen to add match details
     *  for the current match being played.
     */

    private void createAddMatchButton() {
        //Sets up the button to add a match to the MainActivity using a separate activity
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starts Intent to go to the add match activity
                Intent detailActIntent = new Intent(v.getContext(), AddMatchActivity.class);
                finish();
                startActivity(detailActIntent);
                //Creates Toast Message when the user clicks on button to send
                //user to AddMatch Activity
                Toast toast = Toast.makeText(v.getContext(), "Going to Add Match Screen", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }


    /**
     * Sets up the delete match button where the user can click on a list item individually
     * and delete them from not only the listView provided within the MainACtivity, but
     * also the Firebase as well
     */
    private void createDeleteButton(){
        //Sets up the button that deletes a match from the MainActivity Method
        btnDelete = (Button) findViewById(R.id.buttonDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CISMOBILE", "Delete pending");
                Log.d("CISMOBILE", "Delete at position" + positionSelected);
                //tennisDataSource.deleteTennisMatch(tennisList.get(positionSelected));
                tennisMatchAdapter.remove(tennisList.get(positionSelected));
                tennisMatchAdapter.notifyDataSetChanged();
                //Shows Message telling user that Match was deleted from
                //list
                Toast toast = Toast.makeText(v.getContext(), "Deleting Match", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}






