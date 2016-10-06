package com.projectunify.www.Adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by AirUnknown on 2016-10-05.
 */

public class NewsFeedListItemAdaptor extends ArrayAdapter<String> {


    public NewsFeedListItemAdaptor(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
