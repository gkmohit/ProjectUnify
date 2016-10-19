package com.projectunify.www.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectunify.www.Model.Club;
import com.projectunify.www.View.R;

import java.util.ArrayList;

/**
 * Created by AirUnknown on 2016-10-18.
 */

public class ClubsAndTeamsAdaptor extends ArrayAdapter<Club> {


    public ClubsAndTeamsAdaptor(Context context, ArrayList<Club> clubs) {
        super(context, 0, clubs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.clubs_and_teams_list_item, parent, false);
        }
        Club currentItem = getItem(position);

        ImageView clubImage = (ImageView) listItemView.findViewById(R.id.image);
        TextView clubName   = (TextView)  listItemView.findViewById(R.id.club_name);

        clubImage.setImageResource(currentItem.getDrawable());
        clubName.setText(currentItem.getName());

        return listItemView;
    }
}
