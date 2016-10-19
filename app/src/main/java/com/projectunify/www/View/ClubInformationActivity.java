package com.projectunify.www.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectunify.www.Model.Club;
import com.projectunify.www.View.Fragments.ClubsAndTeamsFragment;

public class ClubInformationActivity extends AppCompatActivity {

    Club mClub;
    ImageView mClubImage;
    TextView mClubName;
    TextView mOfficeHours;
    TextView mLocation;
    TextView mPhoneNumber;
    TextView mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_information);
        Intent i = getIntent();
        mClub = (Club) i.getSerializableExtra(ClubsAndTeamsFragment.CLUB);

        mClubImage = (ImageView) findViewById(R.id.club_image);
        mClubName = (TextView) findViewById(R.id.club_name_text);
        mOfficeHours = (TextView) findViewById(R.id.hours_text);
        mLocation = (TextView) findViewById(R.id.location_text);
        mPhoneNumber = (TextView) findViewById(R.id.phone_number_text);
        mEmail = (TextView) findViewById(R.id.email_text);

        try {
            if (mClub != null) {
                mClubImage.setImageResource(mClub.getDrawable());
                mClubName.setText(mClub.getName());
                mOfficeHours.setText(mClub.getHours());
                mLocation.setText(mClub.getOfficeLocation());
                mPhoneNumber.setText(mClub.getPhoneNumber());
                mEmail.setText((mClub.getEmailAddress()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
