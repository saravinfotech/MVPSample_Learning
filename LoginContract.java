package com.sarav.mvpsample;

import android.support.annotation.StringRes;

/**
 * Created by Saravanan on 11/20/2016.
 */

public class LoginContract {

    public interface View{

        String getUserName();

        void setEmptyUserNameErrorMessage(@StringRes int res_id);

        String getPassword();

        void setEmptyPasswordErrorMessage(@StringRes int pass_empty);

        void startSuccessActivity();

        void showFailureMessage();
    }
}
