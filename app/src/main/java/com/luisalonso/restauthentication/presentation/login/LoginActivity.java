package com.luisalonso.restauthentication.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.luisalonso.restauthentication.R;
import com.luisalonso.restauthentication.base.BaseActivity;
import com.luisalonso.restauthentication.presentation.MainActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class LoginActivity extends BaseActivity implements LoginContract.View, Validator.ValidationListener {

    private static final String ARG_USERNAME = "username";
    private static final String ARG_PASSWORD = "password";

    @BindView(R.id.username_field) @NotEmpty EditText mUsernameField;
    @BindView(R.id.password_field) @NotEmpty EditText mPasswordField;
    @BindView(R.id.login_button) Button mLoginButton;

    private LoginContract.Presenter mPresenter;
    private Validator mValidator;

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean hasSecureModeEnable() {
        return true;
    }

    @Override
    protected void setupView(Bundle savedInstanceState) {
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        if (savedInstanceState != null) {
            mUsernameField.setText(savedInstanceState.getString(ARG_USERNAME));
            mPasswordField.setText(savedInstanceState.getString(ARG_PASSWORD));
        }
    }

    @Override
    public LoginContract.Presenter getPresenter() {
        if (mPresenter == null) {
            mPresenter = new LoginPresenter(this);
        }
        return mPresenter;
    }

    @Override
    public void onValidationSucceeded() {
        String username = mUsernameField.getText().toString().trim();
        String password = mPasswordField.getText().toString();
        getPresenter().login(username, password);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        showMessage(R.string.error_form);
    }

    @Override
    public void sendToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @OnClick(value = R.id.login_button)
    void login() {
        mValidator.validate();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String username = mUsernameField.getText().toString().trim();
        String password = mPasswordField.getText().toString();
        outState.putString(ARG_USERNAME, username);
        outState.putString(ARG_PASSWORD, password);
    }
}
