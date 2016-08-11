package com.luisalonso.restauthentication.presentation.login;

import com.luisalonso.restauthentication.R;
import com.luisalonso.restauthentication.network.LoginService;
import com.luisalonso.restauthentication.network.ServiceFactory;
import com.luisalonso.restauthentication.network.model.LoginResponse;
import com.luisalonso.restauthentication.store.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class LoginPresenter implements LoginContract.Presenter, Callback<LoginResponse> {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void start() {
        if (PreferencesManager.sessionExist()) {
            mView.sendToMainActivity();
        }
    }

    @Override
    public void login(String username, String password) {
        mView.startLoader();
        Call<LoginResponse> call = ServiceFactory.retrofitService(LoginService.class)
                .login(username, password);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        mView.stopLoader();
        LoginResponse loginResponse = response.body();
        if (loginResponse.getResult() == 1) {
            PreferencesManager.setSessionState(true);
            mView.sendToMainActivity();
        } else {
            mView.showMessage(loginResponse.getMessage());
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        mView.stopLoader();
        mView.showMessage(R.string.error_default);
    }
}
