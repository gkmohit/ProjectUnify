package com.projectunify.www.Adaptors;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.projectunify.www.View.R;
import com.projectunify.www.View.Fragments.ChatFragment;
import com.projectunify.www.View.Fragments.ClubsAndTeamsFragment;
import com.projectunify.www.View.Fragments.NewsFeedFragment;
import com.projectunify.www.View.Fragments.ProfileFragment;

/**
 * Created by AirUnknown on 2016-10-05.
 */

public class HomePageAdaptor extends FragmentPagerAdapter {

    Context mContext;

    public HomePageAdaptor(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NewsFeedFragment();
        } else if (position == 1) {
            return new ClubsAndTeamsFragment();
        } else if (position == 2) {
            return new ChatFragment();
        } else {
            return new ProfileFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.fragment_title_news_feed);
        } else if (position == 1) {
            return mContext.getString(R.string.fragment_title_clubs_and_teams);
        } else if (position == 2) {
            return mContext.getString(R.string.fragment_title_chat);
        } else {
            return mContext.getString(R.string.fragment_title_profile);
        }
    }
}
