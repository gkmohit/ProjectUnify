package com.projectunify.www.Model;

import java.io.Serializable;

/**
 * Created by AirUnknown on 2016-10-06.
 */

public class Club implements Serializable {

    String mName;
    String mPhotoUrl;
    String mHours;
    String mOfficeLocation;
    String mEmailAddress;
    String mPhoneNumber;
    int mDrawable;


    public Club(String name, String photoUrl) {
        mName = name;
        mPhotoUrl = photoUrl;
    }

    public Club(String name, String hours, String officeLocation, String emailAddress, String phoneNumber, int drawable) {
        mName = name;
        mHours = hours;
        mOfficeLocation = officeLocation;
        mEmailAddress = emailAddress;
        mPhoneNumber = phoneNumber;
        mDrawable = drawable;
    }

    public Club(String name, int drawable) {
        mName = name;
        mDrawable = drawable;
    }

    public String getHours() {
        return mHours;
    }

    public void setHours(String hours) {
        mHours = hours;
    }

    public String getOfficeLocation() {
        return mOfficeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        mOfficeLocation = officeLocation;
    }

    public String getEmailAddress() {
        return mEmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        mEmailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public void setDrawable(int drawable) {
        mDrawable = drawable;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        mPhotoUrl = photoUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
