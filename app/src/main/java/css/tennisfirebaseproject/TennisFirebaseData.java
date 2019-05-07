package css.tennisfirebaseproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TennisFirebaseData {
    DatabaseReference myTennisDbRef;

    /**
     * Opens Google Firebase and references the database with a unique tag and returns the database
     * reference.
     * @return
     */
    public DatabaseReference open() {
        //Writes a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myTennisDbRef = database.getReference("TennisDataTag");
        return myTennisDbRef;
    }

    /**
     * Black constructor for writing the tennnis information to the listview element.
     */
    public void close() {

    }

    /**
     * Returns the new tennisMatch Values into the Google Firebase
     * @param opponentPlayed
     * @param matchPlacement
     * @param playerPlayed
     * @param matchScore
     * @param datePlayed
     * @return
     */
    public TennisMatch createMatch(String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed) {
    //sets up the new tennis object
    String key = myTennisDbRef.child("Tennis Data Tag").push().getKey();
    TennisMatch newTennisMatch = new TennisMatch(key, opponentPlayed, matchPlacement, playerPlayed, matchScore, datePlayed);
    myTennisDbRef.child(key).setValue(newTennisMatch);
    return newTennisMatch;
    }

    /**
     * Removes any tennisMatch Values by removing the unique key within the Google Firebase
     * @param tennisMatch
     */
    public void deleteTennisMatch(TennisMatch tennisMatch){
        String key = tennisMatch.getKey();
        myTennisDbRef.child(key).removeValue();
    }

    /**
     * Creates an arrayList for each tennisMatch value. Runs a for loop where for each datasnapshot
     * the tennisMatch element gets all values form the TennisMatch java class and adds then to
     * the arrayList. Returns list.
     * @param dataSnapshot
     * @return
     */
    public List<TennisMatch> getAllTennisMatch(DataSnapshot dataSnapshot) {
        List<TennisMatch> tennisList = new ArrayList<TennisMatch>();
        for (DataSnapshot data : dataSnapshot.getChildren()){
            TennisMatch tennisMatch = data.getValue(TennisMatch.class);
            tennisList.add(tennisMatch);
        }
        return tennisList;
    }
}




