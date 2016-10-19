package com.projectunify.www.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectunify.www.Model.NewsFeedItem;
import com.projectunify.www.View.R;

import java.util.ArrayList;

/**
 * Created by AirUnknown on 2016-10-05.
 */

public class NewsFeedListItemAdaptor extends ArrayAdapter<NewsFeedItem> {


    public NewsFeedListItemAdaptor(Context context, ArrayList<NewsFeedItem> newsFeedItems) {
        super(context, 0,  newsFeedItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_feed_list_item, parent, false);
        }
        NewsFeedItem currentItem = getItem(position);

        ImageView newFeedClubImage = (ImageView) listItemView.findViewById(R.id.news_feed_club_image);
        TextView newsFeedClubName  = (TextView)  listItemView.findViewById(R.id.news_feed_club_name);
        TextView newFeedNews       = (TextView)  listItemView.findViewById(R.id.news_feed_news);

        //TODO Grab the image from the URL.
        newFeedClubImage.setImageResource(currentItem.getClub().getDrawable());
        newsFeedClubName.setText(currentItem.getClub().getName());
        newFeedNews.setText(currentItem.getPost());
        return listItemView;
    }
}
