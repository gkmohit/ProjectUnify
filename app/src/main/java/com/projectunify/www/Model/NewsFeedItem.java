package com.projectunify.www.Model;

/**
 * Created by AirUnknown on 2016-10-05.
 */

public class NewsFeedItem {

    Club mClub;
    String mPost;
    long mUpvotes;

    public NewsFeedItem(Club club, String post, long upvotes) {
        mClub = club;
        mPost = post;
        mUpvotes = upvotes;
    }

    //TODO remove this add long
    public NewsFeedItem(Club club, String post) {
        mClub = club;
        mPost = post;
    }

    public long getUpvotes() {
        return mUpvotes;
    }

    public void setUpvotes(long upvotes) {
        mUpvotes = upvotes;
    }

    public Club getClub() {
        return mClub;
    }

    public void setClub(Club club) {
        mClub = club;
    }

    public String getPost() {
        return mPost;
    }

    public void setPost(String post) {
        mPost = post;
    }
}
