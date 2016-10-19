package com.projectunify.www.View.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.projectunify.www.Adaptors.ClubsAndTeamsAdaptor;
import com.projectunify.www.Model.Club;
import com.projectunify.www.View.ClubInformationActivity;
import com.projectunify.www.View.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClubsAndTeamsFragment extends Fragment {

    public static final String CLUB = "club";

    ListView mListView;
    ClubsAndTeamsAdaptor mClubsAndTeamsAdaptor;

    public ClubsAndTeamsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_clubs_and_teams, container, false);
        mListView = (ListView) rootView.findViewById(R.id.list);
        //TODO Grab clubs from the database
        final ArrayList<Club> clubs = new ArrayList<>();


        //Club(String name, String hours, String officeLocation, String emailAddress, String phoneNumber, int drawable)
        clubs.add(new Club("Club 1", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_black));
        clubs.add(new Club("Club 2", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_brown));
        clubs.add(new Club("Club 3", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_dusty_yellow));
        clubs.add(new Club("Club 4", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_gray));
        clubs.add(new Club("Club 5", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_green));
        clubs.add(new Club("Club 6", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_mustard_yellow));
        clubs.add(new Club("Club 7", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.color_red));
        clubs.add(new Club("Club 8", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_younger_brother));
        clubs.add(new Club("Club 9", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_daughter));
        clubs.add(new Club("Club 10", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_father));
        clubs.add(new Club("Club 11", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_grandfather));
        clubs.add(new Club("Club 12", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_grandmother));
        clubs.add(new Club("Club 13", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_mother));
        clubs.add(new Club("Club 14", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_older_brother));
        clubs.add(new Club("Club 15", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_older_sister));
        clubs.add(new Club("Club 16", "9 AM to 6 PM", "Building Name, 3rd Floor",
                "clubName@domain.ca", "+1 613 435 2345", R.drawable.family_son));

        mClubsAndTeamsAdaptor = new ClubsAndTeamsAdaptor(getActivity().getBaseContext(), clubs);
        mListView.setAdapter(mClubsAndTeamsAdaptor);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), ClubInformationActivity.class);
                //TODO Pass the club object
                i.putExtra(CLUB, (Club) parent.getAdapter().getItem(position));
                startActivity(i);
            }
        });
        return rootView;
    }

}
