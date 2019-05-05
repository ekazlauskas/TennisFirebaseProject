package css.tennisfirebaseproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class TennisFirebaseData {
    DatabaseReference myTennisDbRef;

    public DatabaseReference open() {
        //Writes a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myTennisDbRef = database.getReference("TennisDataTag");
        return myTennisDbRef;
    }

    public void close() {

    }

    public TennisMatch createMatch(String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed) {
    //sets up the new tennis object
    String key = myTennisDbRef.child("Tennis Data Tag").push().getKey();
    TennisMatch newTennisMatch = new TennisMatch(key, opponentPlayed, matchPlacement, playerPlayed, matchScore, datePlayed);
    myTennisDbRef.child(key).setValue(newTennisMatch);
    return newTennisMatch;
    }

    public void deleteTennisMatch(TennisMatch tennisMatch){
        String key = tennisMatch.getKey();
        myTennisDbRef.child(key).removeValue();
    }

    public List<TennisMatch> getAllTennisMatch(DataSnapshot dataSnapshot) {
        List<TennisMatch> tennisList = new ArrayList<TennisMatch>();
        for (DataSnapshot data : dataSnapshot.getChildren()){
            TennisMatch tennisMatch = data.getValue(TennisMatch.class);
            tennisList.add(tennisMatch);
        }
        return tennisList;
    }
}




