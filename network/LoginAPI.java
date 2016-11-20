package com.sarav.mvpsample.network;

/**
 * Created by Saravanan on 11/20/2016.
 */

public class LoginAPI {

    private final String USER_NAME = "pass";
    private final String PASSWORD = "pass";


    public boolean authenticate(String userName, String password){
        if(userName.equals(USER_NAME) && password.equals(PASSWORD))
            return true;
        return false;
    }
}
