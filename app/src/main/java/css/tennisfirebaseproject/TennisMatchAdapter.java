package css.tennisfirebaseproject;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Creates a tennisMatch adapter that extends from the arrayAdapter with the arrayList.
 */
public class TennisMatchAdapter extends ArrayAdapter<TennisMatch> {

    private List<TennisMatch> tennisList; //The list of Tennis Match Information that is displayed
    private Context context; //the called activity
    private int layoutResource; //the layout the application will display

    /**\
     * sets the context, resource, and the list used to their current states for the application.
     * @param context
     * @param resource
     * @param tennisList
     */
    public TennisMatchAdapter(Context context, int resource, List<TennisMatch> tennisList) {
    super(context, resource, tennisList);
    this.context = context;
    this.layoutResource = resource;
    this.tennisList = tennisList;

    }

    /**
     * Class is designed to view all of the content that is being added with each new match
     * that is created. This also provides which layout the content should be added to and
     * what list to display.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //receives the Tennis Matches that are displaying within the application
        TennisMatch tennisMatch = tennisList.get(position);
        View view;

        //Layout inflater that is used with the created match_layout xml file. Used when displaying
        //listview method data from the AddMatchActivity class.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.match_layout, null);

        //TextView elements that are assigned within the match_layout xml file.
        TextView tvOpponent = (TextView) view.findViewById(R.id.textViewOpponent);
        TextView tvPlacement = (TextView) view.findViewById(R.id.textViewPlacement);
        TextView tvPlayer = (TextView) view.findViewById(R.id.textViewPlayer);
        TextView tvScore = (TextView) view.findViewById(R.id.textViewScore);
        TextView tvDate = (TextView) view.findViewById(R.id.textViewDate);

        //Sets all text to the textView that was given from the TennisMatch class
        tvOpponent.setText(tennisMatch.getOpponentPlayed());
        tvPlacement.setText(tennisMatch.getMatchPlacement());
        tvPlayer.setText(tennisMatch.getPlayerPlayed());
        tvScore.setText(tennisMatch.getMatchScore());
        tvDate.setText(tennisMatch.getDatePlayed());

        //returns the view in the MainActivity
        return(view);
    }
}