package com.sarav.mvpsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sarav.mvpsample.network.LoginAPI;


public class LoginFragment extends Fragment implements LoginContract.View {

    EditText userName, password;
    Button loginButton;

    // private LoginAPI loginAPI;
    private LoginPresenter loginPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        userName = (EditText) view.findViewById(R.id.fragment_UserName);
        password = (EditText) view.findViewById(R.id.fragment_Password);
        loginButton = (Button) view.findViewById(R.id.fragment_Submit);
        loginButton.setOnClickListener(buttonClickListener);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //   loginAPI = new LoginAPI();
        loginPresenter = new LoginPresenter(this, new LoginAPI());
    }

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginPresenter.onLoginButtonClick();
        }
    };

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public void setEmptyUserNameErrorMessage(int res_id) {
        userName.setError(getString(res_id));
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void setEmptyPasswordErrorMessage(int resID) {
        password.setError(getString(resID));
    }

    @Override
    public void startSuccessActivity() {
        Intent i = new Intent(getContext(), MainActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    @Override
    public void showFailureMessage() {
        Toast.makeText(getContext(), R.string.userName_or_password_error, Toast.LENGTH_SHORT).show();
    }
}
