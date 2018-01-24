package com.example.android.quakereport;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Toki on 23/01/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * Constructor
     * @param context Activity
     * @param arrayList Array of the Earthquakes
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the String value for magnitude
        magnitude.setText(Float.toString(currentEarthquake.getmMagnitude()));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // Find the TextView in the list_item.xml layout with the ID place
        TextView place = (TextView) listItemView.findViewById(R.id.place);
        // Get the String value for location
        place.setText(currentEarthquake.getmPlace());

        // Find the TextView in the list_item.xml layout with the ID date
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        // Get the String value for date
        date.setText(currentEarthquake.getDate(currentEarthquake.getmTimeMill()));

        // Find the TextView in the list_item.xml layout with the ID time
        TextView timeHM = (TextView) listItemView.findViewById(R.id.time);
        // Get the String value for time
        timeHM.setText(currentEarthquake.getTime(currentEarthquake.getmTimeMill()));


        return listItemView;

    }

    private int getMagnitudeColor (float magn) {
        int magnitudeColorResourceId;
        int magnitudeRound = Math.round(magn);
        switch (magnitudeRound) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
            return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }
}
