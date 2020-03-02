package com.CMPUT301W20T24.OnMyWay;


import com.google.firebase.auth.FirebaseUser;

/// StackOverflow post by Rupesh
/// Author: https://stackoverflow.com/users/787438/rupesh
/// Answer: https://stackoverflow.com/questions/994840/how-to-create-our-own-listener-interface-in-android
public interface UserInfoPulledListener {
    void onUserInfoPulled(FirebaseUser firebaseUser, boolean isDriver);
}
