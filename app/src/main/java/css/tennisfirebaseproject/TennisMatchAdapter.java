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

public class TennisMatchAdapter extends ArrayAdapter<TennisMatch> {

    private List<TennisMatch> tennisList; //The list of Tennis Match Information that is displayed
    private Context context;
    private int layoutResource;

    public TennisMatchAdapter(Context context, int resource, List<TennisMatch> tennisList) {
    super(context, resource, tennisList);
    this.context = context;
    this.layoutResource = resource;
    this.tennisList = tennisList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //receives the Tennis MAtches that are displaying within the application
        TennisMatch tennisMatch = tennisList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.match_layout, null);

        TextView tvOpponent = (TextView) view.findViewById(R.id.textViewOpponent);
        TextView tvPlacement = (TextView) view.findViewById(R.id.textViewPlacement);
        TextView tvPlayer = (TextView) view.findViewById(R.id.textViewPlayer);
        TextView tvScore = (TextView) view.findViewById(R.id.textViewScore);
        TextView tvDate = (TextView) view.findViewById(R.id.textViewDate);

        //tvOpponent.setText(TennisMatch.getOpponent);
        //tvPlacement.setText(TennisMatch.getPlacement);
        //tvPlayer.setText(TennisMatch.getPlayer);
        //tvScore.setText(TennisMatch.getScore);
        //tvDate.setText(TennisMatch.getDate);

        return(view);
    }
}