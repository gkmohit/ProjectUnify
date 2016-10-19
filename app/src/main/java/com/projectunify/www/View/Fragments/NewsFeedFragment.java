package com.projectunify.www.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.projectunify.www.Adaptors.NewsFeedListItemAdaptor;
import com.projectunify.www.Model.Club;
import com.projectunify.www.Model.NewsFeedItem;
import com.projectunify.www.View.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment {

    ListView mListView;
    NewsFeedListItemAdaptor mNewsFeedListItemAdaptor;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);
        mListView = (ListView) rootView.findViewById(R.id.list);

        //TODO Grab information from the real time database.
        final ArrayList<NewsFeedItem> newsFeedItems = new ArrayList<>();

        newsFeedItems.add(new NewsFeedItem(new Club("Club 1", R.drawable.color_black),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 2", R.drawable.color_brown),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 3", R.drawable.color_dusty_yellow),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 4", R.drawable.color_gray),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 5", R.drawable.color_green),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 6", R.drawable.color_mustard_yellow),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 7", R.drawable.color_red),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 8", R.drawable.family_grandfather),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 9", R.drawable.family_daughter),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 10", R.drawable.family_older_sister),
                getString(R.string.placeholder_news_feed_club_text)));
        newsFeedItems.add(new NewsFeedItem(new Club("Club 11", R.drawable.family_son),
                getString(R.string.placeholder_news_feed_club_text)));

        mNewsFeedListItemAdaptor = new NewsFeedListItemAdaptor(getActivity().getBaseContext(), newsFeedItems);
        mListView.setAdapter(mNewsFeedListItemAdaptor);
        return rootView;
    }

}
