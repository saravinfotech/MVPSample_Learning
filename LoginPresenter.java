package com.sarav.mvpsample;

import com.sarav.mvpsample.network.LoginAPI;

/**
 * Created by Saravanan on 11/20/2016.
 */
public class LoginPresenter {

    private final LoginContract.View view;
    private final LoginAPI loginAPI;

    public LoginPresenter(LoginContract.View view, LoginAPI loginAPI) {
        this.view = view;
        this.loginAPI = loginAPI;
    }

    public void onLoginButtonClick() {
        String userName = view.getUserName();
        if(userName.isEmpty()){
            view.setEmptyUserNameErrorMessage(R.string.userName_Empty);
            return;
        }

        String password = view.getPassword();
        if(password.isEmpty()){
            view.setEmptyPasswordErrorMessage(R.string.pass_Empty);
            return;
        }

        if(loginAPI.authenticate(userName,password)){
            view.startSuccessActivity();
            return;
        }

        view.showFailureMessage();
    }
}
