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
    TennisMatch newTennisMatch = new TennisMatch(opponentPlayed, matchPlacement, playerPlayed, matchScore, datePlayed);
    return newTennisMatch;
    }

    public void deleteTEnnisMAtch(TennisMatch tennisMatch){
        myTennisDbRef.removeValue();
    }

    public List<TennisMatch> getAllTennisMatch(DataSnapshot dataSnapshot) {
        List<TennisMatch> tennisMatchList = new ArrayList<TennisMatch>();
        for (DataSnapshot data : dataSnapshot.getChildren()){
            TennisMatch tennisMatch = data.getValue(TennisMatch.class);
            tennisMatchList.add(tennisMatch);
        }
        return tennisMatchList;
    }
}




