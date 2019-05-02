package css.tennisfirebaseproject;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TennisFirebaseData {
    DatabaseReference myTennisDbRef;

    public DatabaseReference open() {
        //Writes a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myTennisDbRef = database.getReference("Tennis Data Tag");
        return myTennisDbRef;
    }

    public void close() {

    }

    public TennisMatch createMatch(String opponentPlayed, String matchPlacement, String playerPlayed, String matchScore, String datePlayed) {
    
    }
}




